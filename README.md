Smart AC Control System

📌 Description

This project is a smart air conditioner control system developed using Java Swing GUI and Arduino.
The system allows users to control the AC remotely via a graphical interface and receive feedback from the hardware.

---

🛠 Technologies Used

- Java (Swing GUI)
- Arduino
- Serial Communication (USB)

---

⚙️ Features

- AC ON → LED turns ON
- AC OFF → LED turns OFF
- Fan Mode → LED blinks
- Reset → System resets (LED OFF)

---

🔌 Communication Protocol

Commands sent from Java to Arduino:

- "1" → AC ON (LED ON)
- "2" → AC OFF (LED OFF)
- "3" → FAN MODE (LED BLINK)
- "4" → RESET (LED OFF)

---

📡 Status Feedback

Arduino sends back status messages to the Java GUI.

Examples:

- "AC ON"
- "AC OFF"
- "FAN MODE"
- "RESET"

---

💡 How it works

The Java application sends commands to Arduino via serial communication.
Arduino reads these commands, controls the LED accordingly, and sends back status messages to the GUI.

---

🔧 Hardware Setup

- Arduino Uno
- LED
- Resistor (220Ω)
- USB Cable

---

▶️ How to Run

1. Connect Arduino to the computer via USB.
2. Upload the Arduino code using Arduino IDE.
3. Close Arduino IDE.
4. Run the Java application.
5. Select the correct COM port.
6. Use the GUI buttons to control the system.

---

📤 How to Upload Arduino Code

1. Open Arduino IDE.
2. Select the correct board (Arduino Uno).
3. Select the correct COM port.
4. Upload the ".ino" file.

---

🎯 Purpose

This project simulates a smart home air conditioning system with bidirectional communication between software and hardware.

