# code from https://circuitdigest.com/microcontroller-projects/raspberry-pi-xbee-module-interfacing

import time
import serial
import RPi.GPIO as GPIO
from time import sleep

GPIO.setmode(GPIO.BOARD)
GPIO.setup(18, GPIO.OUT)

ser = serial.Serial(
    port='/dev/ttyUSB0',
    baudrate = 9600,
    parity=serial.PARITY_NONE,
    stopbits=serial.STOPBITS_ONE,
    bytesize=serial.EIGHTBITS,
    timeout=1
)

messages=ser.readline().strip()
if (messages == 1003):
    GPIO.output(18, 1)

if (messages == 1004):
    GPIO.output(18, 1)


