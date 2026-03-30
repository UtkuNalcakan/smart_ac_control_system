import com.fazecast.jSerialComm.SerialPort;
import javax.swing.*;
import java.io.InputStream;

public class ACControlGUI {

    static SerialPort arduinoPort;
    static JLabel statusLabel;

    public static void main(String[] args) {

        arduinoPort = SerialPort.getCommPort("COM3"); // okulda COM değişebilir
        arduinoPort.setBaudRate(9600);
        arduinoPort.openPort();

        JFrame frame = new JFrame("Smart AC Control");
        frame.setSize(300, 300);
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

        statusLabel = new JLabel("Status: Waiting...");
        statusLabel.setBounds(50, 190, 200, 30);
        frame.add(statusLabel);

        onBtn.addActionListener(e -> sendCommand("1"));
        offBtn.addActionListener(e -> sendCommand("2"));
        fanBtn.addActionListener(e -> sendCommand("3"));
        resetBtn.addActionListener(e -> sendCommand("4"));

        startReadingFromArduino();

        frame.setVisible(true);
    }

    public static void sendCommand(String command) {
        if (arduinoPort != null && arduinoPort.isOpen()) {
            byte[] buffer = command.getBytes();
            arduinoPort.writeBytes(buffer, buffer.length);
        }
    }

    public static void startReadingFromArduino() {
        Thread thread = new Thread(() -> {
            try {
                InputStream input = arduinoPort.getInputStream();
                StringBuilder message = new StringBuilder();

                while (true) {
                    int data = input.read();

                    if (data == -1) {
                        continue;
                    }

                    if (data == '\n') {
                        String received = message.toString().trim();

                        SwingUtilities.invokeLater(() ->
                            statusLabel.setText("Status: " + received)
                        );

                        System.out.println("Arduino: " + received);
                        message.setLength(0);
                    } else {
                        message.append((char) data);
                    }
                }
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                    statusLabel.setText("Status: Connection Error")
                );
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
}
 
