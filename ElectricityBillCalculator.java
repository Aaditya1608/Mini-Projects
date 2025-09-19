import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ElectricityBillCalculator extends JFrame {

    private JTextField consumerNameField, consumerNumberField, prevReadingField, currReadingField, billField;
    private JRadioButton domesticRadioButton, commercialRadioButton;
    private ButtonGroup connectionTypeGroup;
    private JButton calculateButton;

    public ElectricityBillCalculator() {
        setTitle("Electricity Bill Calculator");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Consumer Name:"));
        consumerNameField = new JTextField(20);
        add(consumerNameField);

        add(new JLabel("Consumer Number:"));
        consumerNumberField = new JTextField(20);
        add(consumerNumberField);

        add(new JLabel("Previous Meter Reading:"));
        prevReadingField = new JTextField(10);
        add(prevReadingField);

        add(new JLabel("Current Meter Reading:"));
        currReadingField = new JTextField(10);
        add(currReadingField);

        add(new JLabel("Connection Type:"));
        domesticRadioButton = new JRadioButton("Domestic");
        commercialRadioButton = new JRadioButton("Commercial");
        connectionTypeGroup = new ButtonGroup();
        connectionTypeGroup.add(domesticRadioButton);
        connectionTypeGroup.add(commercialRadioButton);
        add(domesticRadioButton);
        add(commercialRadioButton);

        calculateButton = new JButton("Calculate Bill");
        add(calculateButton);

        add(new JLabel("Total Bill (in Rs.):"));
        billField = new JTextField(15);
        billField.setEditable(false);
        add(billField);

        calculateButton.addActionListener(e -> calculateBill());
    }

    private void calculateBill() {
        try {
            double prevReading = Double.parseDouble(prevReadingField.getText());
            double currReading = Double.parseDouble(currReadingField.getText());
            double unitsConsumed = currReading - prevReading;

            if (unitsConsumed < 0) {
                JOptionPane.showMessageDialog(this, "Current reading must be greater than previous reading.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double totalBill = 0;
            if (domesticRadioButton.isSelected()) {
                totalBill = calculateDomesticBill(unitsConsumed);
            } else if (commercialRadioButton.isSelected()) {
                totalBill = calculateCommercialBill(unitsConsumed);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a connection type.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            billField.setText("Rs. " + totalBill);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double calculateDomesticBill(double units) {
        if (units <= 100) {
            return units * 1.0;
        } else if (units <= 200) {
            return 100 * 1.0 + (units - 100) * 2.5;
        } else if (units <= 500) {
            return 100 * 1.0 + 100 * 2.5 + (units - 200) * 4.0;
        } else {
            return 100 * 1.0 + 100 * 2.5 + 300 * 4.0 + (units - 500) * 6.0;
        }
    }

    private double calculateCommercialBill(double units) {
        if (units <= 100) {
            return units * 2.0;
        } else if (units <= 200) {
            return 100 * 2.0 + (units - 100) * 4.5;
        } else if (units <= 500) {
            return 100 * 2.0 + 100 * 4.5 + (units - 200) * 6.0;
        } else {
            return 100 * 2.0 + 100 * 4.5 + 300 * 6.0 + (units - 500) * 7.0;
        }
    }
}
