#!/usr/bin/env python3

# Import required Python libraries
import paho. Mqtt.client as mqtt
import RPi.GPIO as GPIO
from mfrc522 import SimpleMFRC522
import time
import ssl

#hier die Ip-Adresse des Brokers eintragen
broker='10.100.240.15'
port=1883
#hier kann man das Topic ändern
publish_topic="raetsel"
clientid="“
#hier alle so lassen
username=‘pi‘
password='pi‘
insecure=True
qos=0
retain_message=False

reader=SimpleMFRC522()

def on_connect(client, userdata, flags, rc):
 
    if rc == 0:
        print ("Connection established!")
        global Connected
        Connected=True
    else:
        print ("Connect failed!");

Connected = False	#global variable for the state of the connection

client=mqtt.Client("control1")
client.username_pw_set(username, password)
client.on_connect= on_connect
Client.connect (broker, port=port)
Client.loop_start()

try:
    while True:
        print("Reminder the script is still running")
        id, text = reader.read()
        client.publish(publish_topic,text)
        time.sleep(5.0)
        exit()
    except RuntimeError as error:
        print(error.args[0])
        time.sleep(5)

except KeyboardInterrupt:
    client.disconnect()
    client.loop_stop()