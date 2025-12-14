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
         
        JLabel titleLabel = new JLabel("Select an Application:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel);

        // Array of options for the JComboBox
        String[] options = {"", "Electricity Bill Calculator", "Employee PaySlip","Shape Area","Exception Program","Multithreading operation", "Producer-Consumer Program","Job Application","Mouse Listener","String Compare","String Buffer","File Information"};
        JComboBox<String> appSelector = new JComboBox<>(options);
        appSelector.setMaximumRowCount(10);
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
                    case "Job Application":
                        JobApplicationSwing j = new JobApplicationSwing();
                        j.setVisible(true);
                        break;
                    case "Mouse Listener":
                        MouseEventDemo m = new MouseEventDemo();
                        m.setVisible(true);
                        break;
                    case "String Compare":
                        StringCompareDemo sc = new StringCompareDemo();
                        sc.setVisible(true);
                        break;
                    case "String Buffer":
                        StringBufferDemo sb = new StringBufferDemo();
                        sb.setVisible(true);
                        break;
                    case "File Information":
                        FileInfoSwing f = new FileInfoSwing();
                        f.setVisible(true);
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