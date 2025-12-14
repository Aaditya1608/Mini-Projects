import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StringBufferProgramSwing {

    StringBuffer sb;

    public StringBufferProgramSwing(String str) {
        sb = new StringBuffer(str);
    }

    public void insert(int offset, String strToInsert) {
        sb.insert(offset, strToInsert);
    }

    public void delete(int start, int end) {
        sb.delete(start, end);
    }

    public void append(String strToAppend) {
        sb.append(strToAppend);
    }

    public void reverse() {
        sb.reverse();
    }

    public int capacity() {
        return sb.capacity();
    }

    public String getString() {
        return sb.toString();
    }
}

public class StringBufferDemo extends JFrame implements ActionListener {

    JTextField inputField, offsetField, insertField, startField, endField, appendField;
    JLabel resultLabel;
    JButton insertBtn, deleteBtn, appendBtn, reverseBtn, capacityBtn;

    StringBufferProgramSwing sbp;

    public StringBufferDemo() {

        setTitle("StringBuffer Methods - Swing Demo");
        setSize(600, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel inputLabel = new JLabel("Initial String:");
        inputLabel.setBounds(40, 30, 100, 25);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(150, 30, 250, 25);
        add(inputField);

        JButton createBtn = new JButton("Create StringBuffer");
        createBtn.setBounds(420, 30, 150, 25);
        add(createBtn);

        // Insert fields
        JLabel offsetLabel = new JLabel("Offset:");
        offsetLabel.setBounds(40, 80, 100, 25);
        add(offsetLabel);

        offsetField = new JTextField();
        offsetField.setBounds(150, 80, 50, 25);
        add(offsetField);

        JLabel insertLabel = new JLabel("Insert String:");
        insertLabel.setBounds(220, 80, 100, 25);
        add(insertLabel);

        insertField = new JTextField();
        insertField.setBounds(320, 80, 200, 25);
        add(insertField);

        insertBtn = new JButton("Insert");
        insertBtn.setBounds(150, 120, 100, 30);
        add(insertBtn);

        // Delete fields
        JLabel startLabel = new JLabel("Start Index:");
        startLabel.setBounds(40, 170, 100, 25);
        add(startLabel);

        startField = new JTextField();
        startField.setBounds(150, 170, 50, 25);
        add(startField);

        JLabel endLabel = new JLabel("End Index:");
        endLabel.setBounds(220, 170, 100, 25);
        add(endLabel);

        endField = new JTextField();
        endField.setBounds(320, 170, 50, 25);
        add(endField);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(400, 170, 100, 30);
        add(deleteBtn);

        // Append
        JLabel appendLabel = new JLabel("Append String:");
        appendLabel.setBounds(40, 220, 120, 25);
        add(appendLabel);

        appendField = new JTextField();
        appendField.setBounds(150, 220, 200, 25);
        add(appendField);

        appendBtn = new JButton("Append");
        appendBtn.setBounds(370, 220, 100, 30);
        add(appendBtn);

        // Other buttons
        reverseBtn = new JButton("Reverse");
        reverseBtn.setBounds(150, 270, 100, 30);
        add(reverseBtn);

        capacityBtn = new JButton("Capacity");
        capacityBtn.setBounds(270, 270, 120, 30);
        add(capacityBtn);

        resultLabel = new JLabel("Current String: ");
        resultLabel.setBounds(40, 330, 520, 30);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(resultLabel);

        // Button actions
        createBtn.addActionListener(e -> {
            sbp = new StringBufferProgramSwing(inputField.getText());
            resultLabel.setText("Current String: " + sbp.getString());
        });

        insertBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        appendBtn.addActionListener(this);
        reverseBtn.addActionListener(this);
        capacityBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == insertBtn) {
                int offset = Integer.parseInt(offsetField.getText());
                sbp.insert(offset, insertField.getText());
                resultLabel.setText("Current String: " + sbp.getString());
            }
            else if (e.getSource() == deleteBtn) {
                int start = Integer.parseInt(startField.getText());
                int end = Integer.parseInt(endField.getText());
                sbp.delete(start, end);
                resultLabel.setText("Current String: " + sbp.getString());
            }
            else if (e.getSource() == appendBtn) {
                sbp.append(appendField.getText());
                resultLabel.setText("Current String: " + sbp.getString());
            }
            else if (e.getSource() == reverseBtn) {
                sbp.reverse();
                resultLabel.setText("Current String: " + sbp.getString());
            }
            else if (e.getSource() == capacityBtn) {
                resultLabel.setText("Capacity: " + sbp.capacity());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    public static void main(String[] args) {
        new StringBufferDemo();
    }
}
