package rfid;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Read implements MqttCallback {

	private final String brokerURL = "tcp://10.100.240.25";
	private final String clientID = "";
	private final String topic = "raetsel";

	Questions que = new Questions(getRandomNumber(1, 11));
	private MqttClient myClient;

	public Read() {
		subscribe(topic);
	}

	private void subscribe(String topic) {
		MemoryPersistence persistence = new MemoryPersistence();
		try {
			myClient = new MqttClient(brokerURL, clientID, persistence);

			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);

			System.out.println("checking");
			System.out.println("Mqtt connectiong to broker " + brokerURL);

			myClient.connect(connOpts);
			System.out.println("Mqtt connect");

			myClient.setCallback(this);
			myClient.subscribe(topic);

			System.out.println("listening");
			que.getQuestion();
		} catch (MqttException NI) {
			System.out.println(NI);
		}
	}

	private int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void messageArrived(String topic, MqttMessage message)
			throws RuntimeException {
		System.out.println(checkAnswer(message.toString().trim()));
		System.out.println("Deine Antwort war: " + message.toString());
		System.exit(1);
	}

	private String checkAnswer(String answer) {
		if (answer.equals(que.getAnswer())) {
			return "Das war die richtige Antwort";
		}
		return "Die Antwort war nicht richtig";
	}

}
