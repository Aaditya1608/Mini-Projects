import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Home Page");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Java Open Ended Experiment");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(25, 25, 112));

        JLabel subtitleLabel = new JLabel("");
        subtitleLabel.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        subtitleLabel.setForeground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        contentPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        contentPanel.add(subtitleLabel, gbc);

        add(contentPanel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new GridLayout(1, 12));

        menuBar.add(createMenu("Electricity Bill", () ->
                showFrame(new ElectricityBillCalculator())));

        menuBar.add(createMenu("Employee Pay Slip", () ->
                showFrame(new MainSwing())));

        menuBar.add(createMenu("Job Application", () ->
                showFrame(new JobApplicationSwing())));

        menuBar.add(createMenu("File Information", () ->
                showFrame(new FileInfoSwing())));

        menuBar.add(createMenu("Shape Area", () ->
                showFrame(new ShapeGUI())));

        menuBar.add(createMenu("Exception Handling", () ->
                showFrame(new ExceptionDemoGUI())));

        menuBar.add(createMenu("Multithreading", () ->
                showFrame(new ThreadGUI())));

        menuBar.add(createMenu("Producer-Consumer", () ->
                showFrame(new ProducerConsumerGUI())));

        menuBar.add(createMenu("Mouse Listener", () ->
                showFrame(new MouseEventDemo())));

        menuBar.add(createMenu("String Compare", () ->
                showFrame(new StringCompareDemo())));

        menuBar.add(createMenu("String Buffer", () ->
                showFrame(new StringBufferDemo())));

        menuBar.add(createMenu("Exit", () -> System.exit(0)));

        setJMenuBar(menuBar);
    }

    private void showFrame(JFrame frame) {
        frame.setVisible(true);
        frame.setExtendedState(JFrame.NORMAL);
        frame.toFront();
        frame.requestFocus();
    }

    private JMenu createMenu(String title, Runnable action) {
        JMenu menu = new JMenu(title);
        menu.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        menu.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                MenuSelectionManager.defaultManager().clearSelectedPath();
                action.run();
            }
            public void menuDeselected(MenuEvent e) {}
            public void menuCanceled(MenuEvent e) {}
        });
        return menu;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new HomePage().setVisible(true));
    }
}
