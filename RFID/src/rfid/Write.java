package rfid;

import java.util.Scanner;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class Write {

	private final String topic = "raetsel";
	String broker = "tcp://10.100.240.15";
	String clientID = "";
	MqttClient myclient;

	MemoryPersistence persistence = new MemoryPersistence();

	public Write() {
		publish();
	}

	private void publish() {
		String content = "";
		Scanner scanner = new Scanner(System.in);

		try {
			myclient = new MqttClient(broker, clientID, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			myclient.connect(connOpts);
			System.out.println("Conecting to Broker " + broker);

				content = scanner.next();
				MqttMessage message = new MqttMessage(content.getBytes());
				System.out.println("message " + message);
				myclient.publish(topic, message);
			
		} catch (MqttException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				System.out.println("beendet");
				myclient.disconnect();
				myclient.close();
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
		scanner.close();
	}
}
