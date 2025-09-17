
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElectricityBillCalculator extends JFrame {
    
    private JTextField consumerNameField, consumerNumberField, prevReadingField, currReadingField, billField;
    private JRadioButton domesticRadioButton, commercialRadioButton;
    private ButtonGroup connectionTypeGroup;
    private JButton calculateButton;
    
    public ElectricityBillCalculator() {
        setTitle("Electricity Bill Calculator");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        
        JLabel nameLabel = new JLabel("Consumer Name:");
        consumerNameField = new JTextField(20);
        
        JLabel numberLabel = new JLabel("Consumer Number:");
        consumerNumberField = new JTextField(20);
        
        JLabel prevReadingLabel = new JLabel("Previous Meter Reading:");
        prevReadingField = new JTextField(10);
        
        JLabel currReadingLabel = new JLabel("Current Meter Reading:");
        currReadingField = new JTextField(10);
        
        JLabel typeLabel = new JLabel("Connection Type:");
        domesticRadioButton = new JRadioButton("Domestic");
        commercialRadioButton = new JRadioButton("Commercial");
        
        connectionTypeGroup = new ButtonGroup();
        connectionTypeGroup.add(domesticRadioButton);
        connectionTypeGroup.add(commercialRadioButton);
        
        calculateButton = new JButton("Calculate Bill");
        
        JLabel billLabel = new JLabel("Total Bill (in Rs.):");
        billField = new JTextField(15);
        billField.setEditable(false);
        
        add(nameLabel);
        add(consumerNameField);
        add(numberLabel);
        add(consumerNumberField);
        add(prevReadingLabel);
        add(prevReadingField);
        add(currReadingLabel);
        add(currReadingField);
        add(typeLabel);
        add(domesticRadioButton);
        add(commercialRadioButton);
        add(calculateButton);
        add(billLabel);
        add(billField);
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBill();
            }
        });
    }
    
    private void calculateBill() {
        try {
            String consumerName = consumerNameField.getText();
            String consumerNumber = consumerNumberField.getText();
            double prevReading = Double.parseDouble(prevReadingField.getText());
            double currReading = Double.parseDouble(currReadingField.getText());
            double unitsConsumed = currReading - prevReading;
            
            double totalBill = 0;
            boolean isDomestic = domesticRadioButton.isSelected();
            
            if (isDomestic) {
                totalBill = calculateDomesticBill(unitsConsumed);
            } else if (commercialRadioButton.isSelected()) {
                totalBill = calculateCommercialBill(unitsConsumed);
            }
            
            billField.setText("Rs. " + totalBill);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private double calculateDomesticBill(double units) {
        double bill = 0;
        
        if (units <= 100) {
            bill = units * 1.0;
        } else if (units >100 && units <= 200) {
            bill = (100 * 1.0) + ((units - 100) * 2.5);
        } else if (units >200 && units <= 500) {
            bill = (100 * 1.0) + (100 * 2.5) + ((units - 200) * 4.0);
        } else {
            bill = (100 * 1.0) + (100 * 2.5) + (300 * 4.0) + ((units - 500) * 5.0);
        }
        
        return bill;
    }
    
    private double calculateCommercialBill(double units) {
        double bill = 0;
        
        if (units <= 100) {
            bill = units * 2.0;
        } else if (units > 100 && units <= 200) {
            bill = (100 * 2.0) + ((units - 100) * 4.5);
        } else if (units > 200 && units <= 500) {
            bill = (100 * 2.0) + (100 * 4.5) + ((units - 200) * 6.0);
        } else {
            bill = (100 * 2.0) + (100 * 4.5) + (300 * 6.0) + ((units - 500) * 7.0);
        }
        
        return bill;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ElectricityBillCalculator().setVisible(true);
            }
        });
    }
}
