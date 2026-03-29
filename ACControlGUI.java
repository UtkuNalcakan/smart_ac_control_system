import com.fazecast.jSerialComm.SerialPort;
import javax.swing.*;

public class ACControlGUI {

    static SerialPort arduinoPort;

    public static void main(String[] args) {

        arduinoPort = SerialPort.getCommPort("COM3");
        arduinoPort.setBaudRate(9600);
        arduinoPort.openPort();

        JFrame frame = new JFrame("Smart AC Control");
        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton onBtn = new JButton("AC ON");
        onBtn.setBounds(50, 20, 200, 30);
        frame.add(onBtn);

        JButton offBtn = new JButton("AC OFF");
        offBtn.setBounds(50, 60, 200, 30);
        frame.add(offBtn);

        JButton fanBtn = new JButton("FAN MODE");
        fanBtn.setBounds(50, 100, 200, 30);
        frame.add(fanBtn);

        JButton resetBtn = new JButton("RESET");
        resetBtn.setBounds(50, 140, 200, 30);
        frame.add(resetBtn);

        onBtn.addActionListener(e -> sendCommand("1"));
        offBtn.addActionListener(e -> sendCommand("2"));
        fanBtn.addActionListener(e -> sendCommand("3"));
        resetBtn.addActionListener(e -> sendCommand("4"));

        frame.setVisible(true);
    }

    public static void sendCommand(String command) {
        if (arduinoPort != null && arduinoPort.isOpen()) {
            byte[] buffer = command.getBytes();
            arduinoPort.writeBytes(buffer, buffer.length);
        }
    }
}
