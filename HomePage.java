import javax.swing.*;
import java.awt.*;


public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Home Page");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton calculatorButton = new JButton("Calculator");
        JButton employeePaySlipButton = new JButton("Employee PaySlip");
        JButton electricityBillButton = new JButton("Electricity Bill Calculator");

        add(calculatorButton);
        add(employeePaySlipButton);
        add(electricityBillButton);


        calculatorButton.addActionListener(e -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });


        employeePaySlipButton.addActionListener(e -> {
            MainSwing.launchWindow();
        });


        electricityBillButton.addActionListener(e -> {
            ElectricityBillCalculator billCalculator = new ElectricityBillCalculator();
            billCalculator.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }
}
