/**************************************************************************/
/*! The code for controlling and reading the NFC card is from readMifare.pde by  
 * Adafruit Industries

*/
/**************************************************************************/
#include <Wire.h>
#include <SPI.h>
#include <Adafruit_PN532.h>

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

void setup(void) {
  #ifndef ESP8266
    while (!Serial); // for Leonardo/Micro/Zero
  #endif
  Serial.begin(115200);
  Serial.println("Starting reading");
  pinMode(SPEAKER_PIN, OUTPUT);
  nfc.begin();

  nfc.SAMConfig();
}


void loop(void) {
  uint8_t success;
  uint8_t uid[] = { 0, 0, 0, 0, 0, 0, 0 };  // Buffer to store the returned UID
  uint8_t uidLength;                        // Length of the UID (4 or 7 bytes depending on ISO14443A card type)
  int value = 0;
    
  // Wait for an ISO14443A type cards (Mifare, etc.).  When one is found
  // 'uid' will be populated with the UID, and uidLength will indicate
  // if the uid is 4 bytes (Mifare Classic) or 7 bytes (Mifare Ultralight)
  success = nfc.readPassiveTargetID(PN532_MIFARE_ISO14443A, uid, &uidLength);
  
  if (success) {
    nfc.PrintHex(uid, uidLength);
    for (int i = 0; i < 7; i++) {
      value += uid[i];
    }

    Serial.println("Playing the value of the card's uid");

    if(value >= 261 && value < 294) {
      Serial.println("Now playing a C");
    }

    if(value >= 294 && value < 329) {
      Serial.println("Now playing a D");
    }

    if(value >= 329 && value < 349) {
      Serial.println("Now playing an E");
    }

    if(value >= 349 && value < 392) {
      Serial.println("Now playing a F");
    }

    if(value >= 392 && value < 440) {
      Serial.println("Now playing a G");
    }

    if(value >= 440 && value < 493) {
      Serial.println("Now playing an A");
    }

    if(value >= 493 && value < 523) {
      Serial.println("Now playing a B");
    }

    if(value >= 523 || value < 261) {
      Serial.println("Entering a different octave");
    }

    tone(SPEAKER_PIN, value);
    delay(10000);
    noTone(SPEAKER_PIN);
  }
  
  delay(2000);
}
