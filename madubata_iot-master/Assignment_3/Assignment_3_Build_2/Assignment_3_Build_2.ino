/*
Code from https://learn.adafruit.com/adafruit-arduino-lesson-16-stepper-motors/arduino-code.
Edited to deal with potentiometers and the switch that controls direction.
Includes code from  https://learn.adafruit.com/adafruit-arduino-lesson-15-dc-motor-reversing/arduino-code
and https://www.brainy-bits.com/stepper-motor-rotary-encoder-p1/.
*/

#include <Stepper.h>

const int stepsPerRevolution = 512; //number of steps per revolution for the motor

int in1Pin = 12;
int in2Pin = 11;
int in3Pin = 10;
int in4Pin = 9;
int switchPin = 7;
int speedPin = A0;
int stepPin = A1;

int previousSpeed = 0;
int previousSteps = 0;  // to how the motor's previous position
int speed = 0;
int steps = 0;

Stepper motor(stepsPerRevolution, in1Pin, in2Pin, in3Pin, in4Pin);  

void setup()
{
  pinMode(in1Pin, OUTPUT);
  pinMode(in2Pin, OUTPUT);
  pinMode(in3Pin, OUTPUT);
  pinMode(in4Pin, OUTPUT);
  pinMode(switchPin, INPUT_PULLUP);
  pinMode(speedPin, INPUT);
  pinMode(stepPin, INPUT);
  
  Serial.begin(9600);
  Serial.println("Starting the motor.");
}

void loop()
{
  speed = analogRead(speedPin);
  speed = map(speed, 0, 1023, 1, 50);
  Serial.print("The speed is now: ");
  Serial.println(speed);
  motor.setSpeed(speed);
  steps = analogRead(stepPin);
  steps = map(steps, 0, 1023, 0, 512);
  boolean reverse = digitalRead(switchPin);
  driveMotor(steps, reverse);
  previousSpeed = speed;
  delay(5000);
}

void driveMotor(int steps, boolean reverse) 
{
  if(steps != abs(previousSteps)) {
    Serial.println("Resetting to previous position.");
    motor.setSpeed(previousSpeed);
    motor.step(-1 * previousSteps);
    delay(1000);
    motor.setSpeed(speed);
  }
  if(reverse) {
    Serial.println("going in reverse.");
    Serial.print("going at ");
    Serial.print(steps);
    Serial.println(" steps.");
    steps = -1 * steps;
    motor.step(steps);
  } else {
    Serial.println("going forwards.");
    Serial.print("going at ");
    Serial.print(steps);
    Serial.println(" steps.");
    motor.step(steps);
  }

  previousSteps = steps;
}
