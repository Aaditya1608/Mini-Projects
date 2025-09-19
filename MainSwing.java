import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Employee {
    String empName;
    String empId;
    String address;
    String mailId;
    String phoneNumber;
    double basicPay;

    public Employee(String empName, String empId, String address, String mailId, String phoneNumber, double basicPay) {
        this.empName = empName;
        this.empId = empId;
        this.address = address;
        this.mailId = mailId;
        this.phoneNumber = phoneNumber;
        this.basicPay = basicPay;
    }
}

class Professor extends Employee {
    public Professor(String empName, String empId, String address, String mailId, String phoneNumber, double basicPay) {
        super(empName, empId, address, mailId, phoneNumber, basicPay);
    }

    public double getGrossSalary() {
        return basicPay + (0.97 * basicPay) + (0.10 * basicPay);
    }

    public double getNetSalary() {
        return getGrossSalary() - (0.12 * basicPay) - (0.001 * basicPay);
    }
}

class AssociateProfessor extends Employee {
    public AssociateProfessor(String empName, String empId, String address, String mailId, String phoneNumber, double basicPay) {
        super(empName, empId, address, mailId, phoneNumber, basicPay);
    }

    public double getGrossSalary() {
        return basicPay + (0.70 * basicPay) + (0.10 * basicPay);
    }

    public double getNetSalary() {
        return getGrossSalary() - (0.12 * basicPay) - (0.001 * basicPay);
    }
}

class AssistantProfessor extends Employee {
    public AssistantProfessor(String empName, String empId, String address, String mailId, String phoneNumber, double basicPay) {
        super(empName, empId, address, mailId, phoneNumber, basicPay);
    }

    public double getGrossSalary() {
        return basicPay + (0.60 * basicPay) + (0.10 * basicPay);
    }

    public double getNetSalary() {
        return getGrossSalary() - (0.12 * basicPay) - (0.001 * basicPay);
    }
}

public class MainSwing extends JFrame {
    public MainSwing() {
        setTitle("Employee Pay Slip");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change to DISPOSE_ON_CLOSE
        setLayout(null);
        setLocationRelativeTo(null); // Center the frame

        JLabel lbl1 = new JLabel("Employee Name");
        lbl1.setBounds(25, 25, 100, 25);
        add(lbl1);

        JTextField txt1 = new JTextField();
        txt1.setBounds(125, 25, 200, 25);
        add(txt1);

        JLabel lbl2 = new JLabel("Employee ID");
        lbl2.setBounds(25, 55, 100, 25);
        add(lbl2);

        JTextField txt2 = new JTextField();
        txt2.setBounds(125, 55, 200, 25);
        add(txt2);

        JLabel lbl3 = new JLabel("Address");
        lbl3.setBounds(25, 85, 100, 25);
        add(lbl3);

        JTextField txt3 = new JTextField();
        txt3.setBounds(125, 85, 200, 25);
        add(txt3);

        JLabel lbl4 = new JLabel("Email ID");
        lbl4.setBounds(25, 115, 100, 25);
        add(lbl4);

        JTextField txt4 = new JTextField();
        txt4.setBounds(125, 115, 200, 25);
        add(txt4);

        JLabel lbl5 = new JLabel("Mobile No.");
        lbl5.setBounds(25, 145, 100, 25);
        add(lbl5);

        JTextField txt5 = new JTextField();
        txt5.setBounds(125, 145, 200, 25);
        add(txt5);

        JLabel lbl6 = new JLabel("Basic Pay");
        lbl6.setBounds(25, 175, 100, 25);
        add(lbl6);

        JTextField txt6 = new JTextField();
        txt6.setBounds(125, 175, 200, 25);
        add(txt6);
        
        JLabel lbl7 = new JLabel("Employee Type");
        lbl7.setBounds(25, 205, 100, 25);
        add(lbl7);

        String[] employeeTypes = {"Professor", "Associate Professor", "Assistant Professor"};
        JComboBox<String> employeeTypeCombo = new JComboBox<>(employeeTypes);
        employeeTypeCombo.setBounds(125, 205, 200, 25);
        add(employeeTypeCombo);

        JButton btn1 = new JButton("Generate PaySlip");
        btn1.setBounds(25, 240, 150, 25);
        add(btn1);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String empName = txt1.getText();
                String empId = txt2.getText();
                String address = txt3.getText();
                String mailId = txt4.getText();
                String phoneNumber = txt5.getText();
                
                try {
                    double basicPay = Double.parseDouble(txt6.getText());
                    String employeeType = (String) employeeTypeCombo.getSelectedItem();
                    
                    Employee employee = null;
                    if (employeeType.equals("Professor")) {
                        employee = new Professor(empName, empId, address, mailId, phoneNumber, basicPay);
                    } else if (employeeType.equals("Associate Professor")) {
                        employee = new AssociateProfessor(empName, empId, address, mailId, phoneNumber, basicPay);
                    } else if (employeeType.equals("Assistant Professor")) {
                        employee = new AssistantProfessor(empName, empId, address, mailId, phoneNumber, basicPay);
                    }

                    if (employee != null) {
                        displayPaySlip(employee);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainSwing.this, "Please enter a valid number for Basic Pay.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void displayPaySlip(Employee employee) {
        JFrame paySlipFrame = new JFrame("Pay Slip");
        paySlipFrame.setSize(400, 400);
        paySlipFrame.setLayout(new GridLayout(0, 1, 10, 10));
        paySlipFrame.setLocationRelativeTo(null);

        paySlipFrame.add(new JLabel("PAY SLIP DETAILS"));
        
        paySlipFrame.add(new JLabel("Name: " + employee.empName));
        paySlipFrame.add(new JLabel("Employee ID: " + employee.empId));
        paySlipFrame.add(new JLabel("Address: " + employee.address));
        paySlipFrame.add(new JLabel("Email ID: " + employee.mailId));
        paySlipFrame.add(new JLabel("Mobile No: " + employee.phoneNumber));

        if (employee instanceof Professor) {
            Professor prof = (Professor) employee;
            paySlipFrame.add(new JLabel("Employee Type: Professor"));
            paySlipFrame.add(new JLabel("Gross Salary: " + String.format("%.2f", prof.getGrossSalary())));
            paySlipFrame.add(new JLabel("Net Salary: " + String.format("%.2f", prof.getNetSalary())));
        } else if (employee instanceof AssociateProfessor) {
            AssociateProfessor assocProf = (AssociateProfessor) employee;
            paySlipFrame.add(new JLabel("Employee Type: Associate Professor"));
            paySlipFrame.add(new JLabel("Gross Salary: " + String.format("%.2f", assocProf.getGrossSalary())));
            paySlipFrame.add(new JLabel("Net Salary: " + String.format("%.2f", assocProf.getNetSalary())));
        } else if (employee instanceof AssistantProfessor) {
            AssistantProfessor asstProf = (AssistantProfessor) employee;
            paySlipFrame.add(new JLabel("Employee Type: Assistant Professor"));
            paySlipFrame.add(new JLabel("Gross Salary: " + String.format("%.2f", asstProf.getGrossSalary())));
            paySlipFrame.add(new JLabel("Net Salary: " + String.format("%.2f", asstProf.getNetSalary())));
        }
        
        paySlipFrame.setVisible(true);
    }
}