import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Home Page");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton calculatorButton = new JButton("Calculator");
        JButton electricityBillButton = new JButton("Electricity Bill Calculator");
        JButton empSalary = new JButton("Employee PaySlip");
        add(calculatorButton);
        add(electricityBillButton);
        add(empSalary);

        calculatorButton.addActionListener(e -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });

        electricityBillButton.addActionListener(e -> {
            ElectricityBillCalculator billCalculator = new ElectricityBillCalculator();
            billCalculator.setVisible(true);
        });

        empSalary.addActionListener(e -> {
            MainSwing mainswing = new MainSwing();
            mainswing.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }
}
