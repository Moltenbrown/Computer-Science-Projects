/*
Code from https://learn.adafruit.com/adafruit-arduino-lesson-16-stepper-motors/arduino-code.
Includes code from https://learn.sparkfun.com/tutorials/xbee-shield-hookup-guide edited to work with
input from a photo resistor and sending output to the motor that is connected to the xbee shield.
Includes code from  https://learn.adafruit.com/adafruit-arduino-lesson-15-dc-motor-reversing/arduino-code.

Most of the code was pulled from Assignment 3. The idea was the use the motor as an thing that could control a
window blind.
*/

#include <Stepper.h>
#include <SoftwareSerial.h>

SoftwareSerial xbee(2, 3);

const int stepsPerRevolution = 512; //number of steps per revolution for the motor

const String statuses[] = {"DARK", "NOT TOO BRIGHT", "TOO BRIGHT"};

int in1Pin = 12;
int in2Pin = 11;
int in3Pin = 10;
int in4Pin = 9;
int photoPin = 0; //used to read from the photosensor to figure out how to edit the curtain position.
int currentCurtainState = 0; //trying to keep track of what position the curtain is.

int speed = 30;
int steps = 0;
boolean reverse = true;

String previous_status = statuses[0];
String status = statuses[0]; 

Stepper motor(stepsPerRevolution, in1Pin, in2Pin, in3Pin, in4Pin);  

void setup()
{
  pinMode(in1Pin, OUTPUT);
  pinMode(in2Pin, OUTPUT);
  pinMode(in3Pin, OUTPUT);
  pinMode(in4Pin, OUTPUT);
  pinMode(photoPin, INPUT);

  xbee.begin(9600);
  Serial.begin(9600);
  Serial.println("Starting the motor.");
}

void loop()
{
  Serial.print("The light is now: ");
  int lightLevel = analogRead(photoPin);
  Serial.println(lightLevel);
  Serial.print("The current curtain state is ");
  Serial.print(status);
  Serial.println(".");
  xbee.write(lightLevel);
  
  if(xbee.available()) { //trying to get the arduino to read from the xbee
    status = String(xbee.readString());
  }
  
  if(status != previous_status) {
    Serial.print("The window is now switching to ");
    Serial.print(status);
    Serial.println (" state.");
    adjustBlinds(status);
    previous_status = status;
    Serial.println(currentCurtainState);
  }

  delay(10000); /* chose 10 minutes as when we would check it because I thought any more
  frequently would lead to a constantly shuttering blind effect. */
}

void adjustBlinds(String status) 
{
  motor.setSpeed(speed);
  if(status == statuses[1]) {
       if(currentCurtainState == 256) {
          currentCurtainState+= 256;
          motor.step(256);
       } else {
          currentCurtainState+=512;
          motor.step(512);
       }
  } else if(status == statuses[2]) {
    if(currentCurtainState > 256) {
      currentCurtainState -=256;
      motor.step(-1 * 256);
    }
  } else if (status == statuses[0]) {
    if(currentCurtainState > 256) {
      currentCurtainState -= 512;
      motor.step(-1 * 512);
    } else {
      currentCurtainState -= 256;
      motor.step(-1 * 256);
    }
  } else {
    Serial.println("The input entered is unsupported. Please try again.");
  }
}
