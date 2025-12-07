import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Home Page");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Array of options for the JComboBox
        String[] options = {"Select an application", "Electricity Bill Calculator", "Employee PaySlip","Shape Area","Exception Program","Multithreading operation", "Producer-Consumer Program"};
        JComboBox<String> appSelector = new JComboBox<>(options);
        add(appSelector);

        // Add an ActionListener to the JComboBox
        appSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) appSelector.getSelectedItem();
                switch (selectedOption) {
                    case "Exception Program":
                        ExceptionDemoGUI exp = new ExceptionDemoGUI();
                        exp.setVisible(true);
                        break;
                    case "Shape Area":
                        ShapeGUI shape = new ShapeGUI();
                        shape.setVisible(true);
                        break;
                    case "Electricity Bill Calculator":
                        ElectricityBillCalculator billCalculator = new ElectricityBillCalculator();
                        billCalculator.setVisible(true);
                        break;
                    case "Employee PaySlip":
                        MainSwing mainswing = new MainSwing();
                        mainswing.setVisible(true);
                        break;
                    case "Multithreading operation":
                        ThreadGUI thread = new ThreadGUI();
                        thread.setVisible(true);
                        break;
                    case "Producer-Consumer Program":
                        ProducerConsumerGUI pc = new ProducerConsumerGUI();
                        pc.setVisible(true);
                        break;

                    default:
                        // Do nothing if "Select an application" is chosen
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }
}