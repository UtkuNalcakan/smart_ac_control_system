int led = 13;

void setup() {
  pinMode(led, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  if (Serial.available() > 0) {
    char command = Serial.read();

    if (command == '1') {
      digitalWrite(led, HIGH); // AC ON
    }
    else if (command == '2') {
      digitalWrite(led, LOW); // AC OFF
    }
    else if (command == '3') {
      digitalWrite(led, HIGH); // FAN MODE (yanıp sönebilir)
      delay(300);
      digitalWrite(led, LOW);
      delay(300);
    }
    else if (command == '4') {
      digitalWrite(led, LOW); // RESET
    }
  }
}
