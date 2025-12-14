import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StringProgramSwing {

    String str1, str2;

    public StringProgramSwing(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public String equalsMethod() {
        if (str1.equals(str2))
            return "The strings are equal";
        else
            return "The strings are not equal";
    }

    public String equalsIgnoreCaseMethod() {
        if (str1.equalsIgnoreCase(str2))
            return "The strings are equal";
        else
            return "The strings are not equal";
    }

    public String startsWithMethod() {
        if (str1.startsWith(str2))
            return "The string 1 starts with string 2";
        else
            return "The string 1 does not start with string 2";
    }

    public String endsWithMethod() {
        if (str1.endsWith(str2))
            return "The string 1 ends with string 2";
        else
            return "The string 1 does not end with string 2";
    }

    public String compareToMethod() {
        int n = str1.compareTo(str2);
        if (n == 0)
            return "The strings are equal";
        else if (n > 0)
            return "The string 1 is greater than string 2";
        else
            return "The string 1 is lesser than string 2";
    }
}

public class StringCompareDemo extends JFrame implements ActionListener {

    JTextField t1, t2;
    JLabel result;
    JButton b1, b2, b3, b4, b5, createBtn;

    StringProgramSwing sp;

    public StringCompareDemo() {

        setTitle("String Comparison Methods - Swing");
        setSize(500, 350);
        setLayout(null);

        JLabel l1 = new JLabel("Enter String 1:");
        l1.setBounds(40, 40, 120, 25);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(170, 40, 250, 25);
        add(t1);

        JLabel l2 = new JLabel("Enter String 2:");
        l2.setBounds(40, 80, 120, 25);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(170, 80, 250, 25);
        add(t2);

        createBtn = new JButton("Create Strings");
        createBtn.setBounds(170, 120, 150, 30);
        add(createBtn);

        b1 = new JButton("Equals()");
        b1.setBounds(40, 170, 100, 30);
        add(b1);

        b2 = new JButton("EqualsIgnoreCase()");
        b2.setBounds(150, 170, 180, 30);
        add(b2);

        b3 = new JButton("StartsWith()");
        b3.setBounds(340, 170, 120, 30);
        add(b3);

        b4 = new JButton("EndsWith()");
        b4.setBounds(90, 210, 120, 30);
        add(b4);

        b5 = new JButton("CompareTo()");
        b5.setBounds(240, 210, 140, 30);
        add(b5);

        result = new JLabel("Result will be displayed here");
        result.setBounds(40, 260, 420, 30);
        result.setFont(new Font("Arial", Font.BOLD, 14));
        add(result);

        createBtn.addActionListener(e -> {
            sp = new StringProgramSwing(t1.getText(), t2.getText());
            result.setText("Strings created successfully");
        });

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (sp == null) {
            JOptionPane.showMessageDialog(this, "Please create strings first!");
            return;
        }

        if (e.getSource() == b1)
            result.setText(sp.equalsMethod());
        else if (e.getSource() == b2)
            result.setText(sp.equalsIgnoreCaseMethod());
        else if (e.getSource() == b3)
            result.setText(sp.startsWithMethod());
        else if (e.getSource() == b4)
            result.setText(sp.endsWithMethod());
        else if (e.getSource() == b5)
            result.setText(sp.compareToMethod());
    }

    public static void main(String[] args) {
        new StringCompareDemo();
    }
}
