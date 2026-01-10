import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Home Page");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Title
        JLabel titleLabel = new JLabel("Select an Application", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Panel for buttons (2 per row)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 2, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font btnFont = new Font("Arial", Font.PLAIN, 14);

        // Helper method for button creation
        buttonPanel.add(createButton("Electricity Bill Calculator", btnFont, e ->
                new ElectricityBillCalculator().setVisible(true)));

        buttonPanel.add(createButton("Employee PaySlip", btnFont, e ->
                new MainSwing().setVisible(true)));

        buttonPanel.add(createButton("Shape Area", btnFont, e ->
                new ShapeGUI().setVisible(true)));

        buttonPanel.add(createButton("Exception Program", btnFont, e ->
                new ExceptionDemoGUI().setVisible(true)));

        buttonPanel.add(createButton("Multithreading Operation", btnFont, e ->
                new ThreadGUI().setVisible(true)));

        buttonPanel.add(createButton("Producer-Consumer Program", btnFont, e ->
                new ProducerConsumerGUI().setVisible(true)));

        buttonPanel.add(createButton("Job Application", btnFont, e ->
                new JobApplicationSwing().setVisible(true)));

        buttonPanel.add(createButton("Mouse Listener", btnFont, e ->
                new MouseEventDemo().setVisible(true)));

        buttonPanel.add(createButton("String Compare", btnFont, e ->
                new StringCompareDemo().setVisible(true)));

        buttonPanel.add(createButton("String Buffer", btnFont, e ->
                new StringBufferDemo().setVisible(true)));

        buttonPanel.add(createButton("File Information", btnFont, e ->
                new FileInfoSwing().setVisible(true)));

        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String text, Font font, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setFocusPainted(false);
        button.addActionListener(action);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage().setVisible(true));
    }
}
