int led = 13;

void setup() {
  pinMode(led, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  if (Serial.available() > 0) {
    char command = Serial.read();

    if (command == '1') {
      digitalWrite(led, HIGH);
      Serial.println("AC ON");
    }
    else if (command == '2') {
      digitalWrite(led, LOW);
      Serial.println("AC OFF");
    }
    else if (command == '3') {
      for (int i = 0; i < 5; i++) {
        digitalWrite(led, HIGH);
        delay(300);
        digitalWrite(led, LOW);
        delay(300);
      }
      Serial.println("FAN MODE");
    }
    else if (command == '4') {
      digitalWrite(led, LOW);
      Serial.println("RESET");
    }
    else {
      Serial.println("UNKNOWN COMMAND");
    }
  }
}
 
