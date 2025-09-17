
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    // Components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Hardcoded credentials
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    public LoginPage() {
        // Frame settings
        setTitle("Login Page");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Panel and layout
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Labels and fields
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Empty label for spacing
        panel.add(new JLabel());

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        panel.add(loginButton);

        // Add panel to frame
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String enteredUsername = usernameField.getText();
        String enteredPassword = new String(passwordField.getPassword());

        if (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::new);
    }
}
