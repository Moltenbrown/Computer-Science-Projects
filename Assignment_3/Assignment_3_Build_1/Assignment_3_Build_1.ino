/*
Code from https://learn.adafruit.com/adafruit-arduino-lesson-15-dc-motor-reversing/arduino-code.
*/

int enablePin = 11;
int in1Pin = 10;
int in2Pin = 9;
int switchPin = 7;
int potPin = A0;

void setup()
{
  Serial.begin(9600);
  Serial.println("Starting the motor.");
  pinMode(in1Pin, OUTPUT);
  pinMode(in2Pin, OUTPUT);
  pinMode(enablePin, OUTPUT);
  pinMode(switchPin, INPUT_PULLUP);
}

void loop()
{
  //int speed = analogRead(potPin) / 4;
  int speed = analogRead(potPin);
  speed = map(speed, 0, 1023, 0, 255); 
  boolean reverse = digitalRead(switchPin);
  setMotor(speed, reverse);
}

void setMotor(int speed, boolean reverse)
{
  if(reverse) {
    Serial.print("going forward at ");
    Serial.println(speed);
  } else {
    Serial.print("going backwards at ");
    Serial.println(speed);
  }
  analogWrite(enablePin, speed);
  digitalWrite(in1Pin, ! reverse);
  digitalWrite(in2Pin, reverse);
}
