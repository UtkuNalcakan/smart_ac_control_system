Smart AC Control System

📌 Description

This project is a smart air conditioner control system developed using Java Swing GUI and Arduino. The system allows users to control the AC via a graphical interface and receive real-time feedback from the hardware through serial communication.

---

🛠 Technologies Used

- Java (Swing GUI)
- Arduino
- Serial Communication (USB / COM Port)

---

⚙️ Features

- AC ON → LED turns ON
- AC OFF → LED turns OFF
- Fan Mode → LED blinks
- Reset → System resets (LED OFF)
- Real-time status feedback displayed in GUI

---

🔌 Hardware Setup

- Arduino Uno
- LED
- Resistor (220Ω)
- USB Cable

---

⬆️ How to Upload Arduino Code

1. Open Arduino IDE
2. Select the correct board (Arduino Uno)
3. Select the correct COM port
4. Upload the ".ino" file

---

▶️ How to Run

1. Connect Arduino to the computer via USB
2. Upload the Arduino code
3. Close Arduino IDE
4. Run the Java application
5. Select the correct COM port
6. Use the GUI buttons to control the system

---

📡 Communication Protocol

The system uses a simple serial communication protocol between the Java GUI and the Arduino via USB (COM port). Each command is sent as a single character.

🔹 Commands (Java → Arduino)

Command | Description | Action on Arduino;
   "1"    | AC ON      | LED turns ON
  ,"2"    | AC OFF     | LED turns OFF
  ,"3"    | FAN MODE   | LED blinks
  ,"4"    | RESET      | LED turns OFF (reset)

---

🔹 Responses (Arduino → Java)

After executing a command, the Arduino sends back a status message:

- "AC ON"
- "AC OFF"
- "FAN MODE"
- "RESET"

---

🔹 Example Communication

Java → Arduino: "1"
Arduino → Java: "AC ON"

Java → Arduino: "3"
Arduino → Java: "FAN MODE"

---

🔹 Notes

- Communication is done via Serial (USB)
- Each message is sent as a single line
- The GUI displays incoming messages in real-time

---
## 🖥️ GUI Screenshot

Below is the graphical user interface of the system:

![GUI](gui.png.jpeg)


---

💡 How It Works

The Java application sends commands to Arduino via serial communication. Arduino reads these commands, controls the LED accordingly, and sends back status messages to the GUI, which are displayed to the user.

---
## 🎯 Purpose

This project demonstrates an end-to-end smart AC control system where a Java Swing GUI communicates with an Arduino via serial (USB). It allows users to control the air conditioner and receive real-time feedback from the system.


