import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Home Page");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame

        JButton calculatorButton = new JButton("Calculator");
        JButton electricityBillButton = new JButton("Electricity Bill Calculator");
        JButton backButton = new JButton("Back");

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));

        add(calculatorButton);
        add(electricityBillButton);
        add(backButton);

        calculatorButton.addActionListener(e -> {
            System.out.println("Calculator button clicked");
        });

        electricityBillButton.addActionListener(e -> {
            System.out.println("Electricity Bill Calculator button clicked");
        });

        backButton.addActionListener(e -> {
            System.out.println("Back button clicked");

        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }
}
