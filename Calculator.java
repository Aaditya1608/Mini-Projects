import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lbl1 = new JLabel("Operand 1");
        lbl1.setBounds(25, 25, 100, 25);
        add(lbl1);

        JTextField txt1 = new JTextField();
        txt1.setBounds(125, 25, 100, 25);
        add(txt1);

        JLabel lbl2 = new JLabel("Operand 2");
        lbl2.setBounds(25, 75, 100, 25);
        add(lbl2);

        JTextField txt2 = new JTextField();
        txt2.setBounds(125, 75, 100, 25);
        add(txt2);

        JButton btnAdd = new JButton("+");
        btnAdd.setBounds(25, 120, 50, 25);
        add(btnAdd);

        JButton btnSub = new JButton("-");
        btnSub.setBounds(85, 120, 50, 25);
        add(btnSub);

        JButton btnMul = new JButton("*");
        btnMul.setBounds(145, 120, 50, 25);
        add(btnMul);

        JButton btnDiv = new JButton("/");
        btnDiv.setBounds(205, 120, 50, 25);
        add(btnDiv);

        JLabel lblResult = new JLabel("Result");
        lblResult.setBounds(25, 160, 100, 25);
        add(lblResult);

        JTextField txtResult = new JTextField();
        txtResult.setBounds(125, 160, 100, 25);
        txtResult.setEditable(false);
        add(txtResult);

        ActionListener listener = e -> {
            try {
                double num1 = Double.parseDouble(txt1.getText());
                double num2 = Double.parseDouble(txt2.getText());
                double result = 0;
                if (e.getSource() == btnAdd) {
                    result = num1 + num2;
                } else if (e.getSource() == btnSub) {
                    result = num1 - num2;
                } else if (e.getSource() == btnMul) {
                    result = num1 * num2;
                } else if (e.getSource() == btnDiv) {
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                }
                txtResult.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers");
            }
        };

        btnAdd.addActionListener(listener);
        btnSub.addActionListener(listener);
        btnMul.addActionListener(listener);
        btnDiv.addActionListener(listener);
    }
}
