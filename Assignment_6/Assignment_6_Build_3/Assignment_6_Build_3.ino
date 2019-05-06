/**************************************************************************/
/*! The code for controlling and reading the NFC card is from readMifare.pde by  
 * Adafruit Industries. Motor code from 
 * https://learn.adafruit.com/adafruit-arduino-lesson-15-dc-motor-reversing/arduino-code.
*/
/**************************************************************************/
#include <Wire.h>
#include <SPI.h>
#include <Adafruit_PN532.h>
#include <Stepper.h>

// If using the breakout with SPI, define the pins for SPI communication.
#define PN532_SCK  (2)
#define PN532_MOSI (3)
#define PN532_SS   (4)
#define PN532_MISO (5)

#define SPEAKER_PIN A0

// If using the breakout or shield with I2C, define just the pins connected
// to the IRQ and reset lines.  Use the values below (2, 3) for the shield!
#define PN532_IRQ   (2)
#define PN532_RESET (3)  // Not connected by default on the NFC Shield

// Or use this line for a breakout or shield with an I2C connection:
Adafruit_PN532 nfc(PN532_IRQ, PN532_RESET);

#if defined(ARDUINO_ARCH_SAMD)
   #define Serial SerialUSB
#endif

const int stepsPerRevolution = 512; //number of steps per revolution for the motor

const uint8_t key[4] = {6, 32, 85, 193};


int in1Pin = 12;
int in2Pin = 11;
int in3Pin = 10;
int in4Pin = 9;

int speed = 30;
int steps = 0;
boolean state = true;
boolean open = false;

Stepper motor(stepsPerRevolution, in1Pin, in2Pin, in3Pin, in4Pin);  

void setup(void) {
  #ifndef ESP8266
    while (!Serial); // for Leonardo/Micro/Zero
  #endif
  Serial.begin(115200);
  Serial.println("Starting reading");
  pinMode(in1Pin, OUTPUT);
  pinMode(in2Pin, OUTPUT);
  pinMode(in3Pin, OUTPUT);
  pinMode(in4Pin, OUTPUT);
  nfc.begin();

  nfc.SAMConfig();

//  uint8_t success;
//  uint8_t uid[] = { 0, 0, 0, 0, 0, 0, 0 };  // Buffer to store the returned UID
//  uint8_t uidLength;                        // Length of the UID (4 or 7 bytes depending on ISO14443A card type)
//  int value = 0;
//    
//  success = nfc.readPassiveTargetID(PN532_MIFARE_ISO14443A, uid, &uidLength);
//  if(success) {
//    Serial.println("Saving key");
//    save_value(uid, uidLength, key);
//    for(int i = 0; i < 7; i++) {
//      Serial.print(key[i]);
//      Serial.print(" ");
//    }
//
//    Serial.println("");
//  }
}


void loop(void) {
  uint8_t success;
  uint8_t uid[] = { 0, 0, 0, 0, 0, 0, 0 };  // Buffer to store the returned UID
  uint8_t uidLength;                        // Length of the UID (4 or 7 bytes depending on ISO14443A card type)
  int value = 0;
    
  success = nfc.readPassiveTargetID(PN532_MIFARE_ISO14443A, uid, &uidLength);
  
  if (success) {
    uint8_t holder[4];
    save_value(uid, uidLength, holder);

    for(int i = 0; i < uidLength; i++) {
      if (holder[i] != key[i]) {
        state = false;
      }
    }
    
    if(state) {
      Serial.println("Welcome home.");
      motor.setSpeed(speed);
      Serial.println("Unlocking door. You have 10 seconds to enter.");
      motor.step(512);
      open = true;
      delay(10000);
      Serial.println("Locking door.");
      motor.step(-512);
      open = false;
    }

    else {
      Serial.println("Unregistered key. Step away from the door or 911 will be called.");
      if (open) {
        motor.step(-512);
      }
    }
  }
  
  delay(2000);
}


void save_value(const byte * data, const uint32_t numBytes, uint8_t *holder)
{
  uint32_t szPos;
  for (szPos=0; szPos < numBytes; szPos++)
  {
    holder[szPos] = data[szPos];
    Serial.println(data[szPos]);
  }
}
