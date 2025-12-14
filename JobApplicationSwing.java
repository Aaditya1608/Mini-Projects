import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// User-defined exception for age < 18
class TooEarlyToApply extends Exception {
    public TooEarlyToApply(String msg) {
        super(msg);
    }
}

// User-defined exception for age > 40
class TooLateToApply extends Exception {
    public TooLateToApply(String msg) {
        super(msg);
    }
}

public class JobApplicationSwing extends JFrame implements ActionListener {

    JTextField nameField, roleField, ageField;
    JButton submitBtn;

    JobApplicationSwing() {
        setTitle("Job Application Form");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(4, 2, 10, 10));

        // Components
        add(new JLabel("Applicant Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Role Looking For:"));
        roleField = new JTextField();
        add(roleField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        add(new JLabel()); // empty cell
        add(submitBtn);

        setVisible(true);
    }

    // Method to check age eligibility
    void checkAge(int age) throws TooEarlyToApply, TooLateToApply {
        if (age < 18) {
            throw new TooEarlyToApply("Too Early To Apply! Minimum age is 18.");
        } else if (age > 40) {
            throw new TooLateToApply("Too Late To Apply! Maximum age is 40.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String name = nameField.getText();
            String role = roleField.getText();
            int age = Integer.parseInt(ageField.getText());

            checkAge(age);

            JOptionPane.showMessageDialog(
                this,
                "Application Accepted!\n\nName: " + name +
                "\nRole: " + role +
                "\nAge: " + age,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (TooEarlyToApply | TooLateToApply ex) {
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Age Error",
                JOptionPane.ERROR_MESSAGE
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid numeric age!",
                "Input Error",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new JobApplicationSwing();
    }
}
