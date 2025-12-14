import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FileInfoSwing extends JFrame implements ActionListener {

    JTextField fileField;
    JTextArea outputArea;
    JButton checkBtn;

    public FileInfoSwing() {

        setTitle("File Information Program");
        setSize(500, 400);
        setLayout(null);

        JLabel label = new JLabel("Enter File Name / Path:");
        label.setBounds(30, 30, 180, 25);
        add(label);

        fileField = new JTextField();
        fileField.setBounds(200, 30, 240, 25);
        add(fileField);

        checkBtn = new JButton("Check File Info");
        checkBtn.setBounds(170, 70, 150, 30);
        add(checkBtn);

        outputArea = new JTextArea();
        outputArea.setBounds(30, 120, 410, 200);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(outputArea);

        checkBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String fileName = fileField.getText();
        File file = new File(fileName);

        outputArea.setText(""); // clear previous output

        if (file.exists()) {
            outputArea.append("File Exists: YES\n");
            outputArea.append("Readable: " + (file.canRead() ? "YES" : "NO") + "\n");
            outputArea.append("Writable: " + (file.canWrite() ? "YES" : "NO") + "\n");

            if (file.isFile())
                outputArea.append("Type: Regular File\n");
            else if (file.isDirectory())
                outputArea.append("Type: Directory\n");

            outputArea.append("File Length: " + file.length() + " bytes\n");
        }
        else {
            outputArea.append("File Exists: NO\n");
        }
    }

    public static void main(String[] args) {
        new FileInfoSwing();
    }
}
