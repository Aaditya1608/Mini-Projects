import javax.swing.*;
import java.awt.*;

public class ElectricityBillCalculator extends JFrame {

    private JTextField consumerNameField, consumerNumberField, prevReadingField, currReadingField, billField;
    private JRadioButton domesticRadioButton, commercialRadioButton;
    private ButtonGroup connectionTypeGroup;
    private JButton calculateButton;

    public ElectricityBillCalculator() {
        setTitle("Electricity Bill Calculator");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.PLAIN, 14);

        // Row 0 - Title
        JLabel title = new JLabel("Electricity Bill Calculator", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridwidth = 1;

        // Row 1 - Consumer Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Consumer Name:"), gbc);

        gbc.gridx = 1;
        consumerNameField = new JTextField(15);
        add(consumerNameField, gbc);

        // Row 2 - Consumer Number
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Consumer Number:"), gbc);

        gbc.gridx = 1;
        consumerNumberField = new JTextField(15);
        add(consumerNumberField, gbc);

        // Row 3 - Previous Reading
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Previous Meter Reading:"), gbc);

        gbc.gridx = 1;
        prevReadingField = new JTextField(15);
        add(prevReadingField, gbc);

        // Row 4 - Current Reading
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Current Meter Reading:"), gbc);

        gbc.gridx = 1;
        currReadingField = new JTextField(15);
        add(currReadingField, gbc);

        // Row 5 - Connection Type
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Connection Type:"), gbc);

        gbc.gridx = 1;
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        domesticRadioButton = new JRadioButton("Domestic");
        commercialRadioButton = new JRadioButton("Commercial");

        connectionTypeGroup = new ButtonGroup();
        connectionTypeGroup.add(domesticRadioButton);
        connectionTypeGroup.add(commercialRadioButton);

        radioPanel.add(domesticRadioButton);
        radioPanel.add(commercialRadioButton);
        add(radioPanel, gbc);

        // Row 6 - Calculate Button
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        calculateButton = new JButton("Calculate Bill");
        add(calculateButton, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Row 7 - Bill Amount
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Total Bill (Rs.):"), gbc);

        gbc.gridx = 1;
        billField = new JTextField(15);
        billField.setEditable(false);
        billField.setFont(new Font("Arial", Font.BOLD, 14));
        add(billField, gbc);

        calculateButton.addActionListener(e -> calculateBill());
    }

    private void calculateBill() {
        try {
            double prevReading = Double.parseDouble(prevReadingField.getText());
            double currReading = Double.parseDouble(currReadingField.getText());
            double unitsConsumed = currReading - prevReading;

            if (unitsConsumed < 0) {
                JOptionPane.showMessageDialog(this,
                        "Current reading must be greater than previous reading.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double totalBill;
            if (domesticRadioButton.isSelected()) {
                totalBill = calculateDomesticBill(unitsConsumed);
            } else if (commercialRadioButton.isSelected()) {
                totalBill = calculateCommercialBill(unitsConsumed);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Please select a connection type.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            billField.setText("Rs. " + totalBill);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numeric values",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private double calculateDomesticBill(double units) {
        if (units <= 100) return units * 1.0;
        else if (units <= 200) return 100 * 1.0 + (units - 100) * 2.5;
        else if (units <= 500) return 100 * 1.0 + 100 * 2.5 + (units - 200) * 4.0;
        else return 100 * 1.0 + 100 * 2.5 + 300 * 4.0 + (units - 500) * 6.0;
    }

    private double calculateCommercialBill(double units) {
        if (units <= 100) return units * 2.0;
        else if (units <= 200) return 100 * 2.0 + (units - 100) * 4.5;
        else if (units <= 500) return 100 * 2.0 + 100 * 4.5 + (units - 200) * 6.0;
        else return 100 * 2.0 + 100 * 4.5 + 300 * 6.0 + (units - 500) * 7.0;
    }
}
