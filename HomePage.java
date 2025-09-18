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

        // Open Calculator window on button click
        calculatorButton.addActionListener(e -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });

        // Open ElectricityBillCalculator window on button click
        electricityBillButton.addActionListener(e -> {
            ElectricityBillCalculator billCalculator = new ElectricityBillCalculator();
            billCalculator.setVisible(true);
        });

        backButton.addActionListener(e -> {
            // Example back button logic: just dispose this window
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }
}
