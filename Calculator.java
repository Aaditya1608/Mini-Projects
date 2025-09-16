import javax.swing.*;
import java.awt.event.*;
public class Calculator {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lbl1 = new JLabel("Operand 1");
        lbl1.setBounds(25, 25,100, 25);
        frame.add(lbl1);

        JTextField txt1 = new JTextField();
        txt1.setBounds(125, 25, 100, 25);
        frame.add(txt1);

        JLabel lbl2 = new JLabel("Operand 2");
        lbl2.setBounds(25, 75,100, 25);
        frame.add(lbl2);

        JTextField txt2 = new JTextField();
        txt2.setBounds(125, 75, 100, 25);
        frame.add(txt2);

        JButton btn1 = new JButton("+");
        btn1.setBounds(25,120,50,25);
        frame.add(btn1);
        JButton btn2 = new JButton("-");
        btn2.setBounds(85,120,50,25);
        frame.add(btn2);
        JButton btn3 = new JButton("*");
        btn3.setBounds(145,120,50,25);
        frame.add(btn3);
        JButton btn4 = new JButton("/");
        btn4.setBounds(205,120,50,25);
        frame.add(btn4);

        JLabel lbl3 = new JLabel("Result");
        lbl3.setBounds(25,160,100,25);
        frame.add(lbl3);

        JTextField txt3 = new JTextField();
        txt3.setBounds(125, 160, 100, 25);
        txt3.setEditable(false);
        frame.add(txt3);

        ActionListener listener = e -> {
            try{
                double num1 = Double.parseDouble(txt1.getText());
                double num2 = Double.parseDouble(txt2.getText());
                double result =0;
                if(e.getSource() == btn1){
                    result = num1 + num2;
                }
                else if(e.getSource()== btn2){
                    result = num1 - num2;
                }
                else if(e.getSource()== btn3){
                    result = num1*num2;
                }
                else if(e.getSource()==btn4){
                    if(num2==0){
                        JOptionPane.showMessageDialog(frame, "Cannot divide by zero");
                        return;
                    }
                    result = num1/num2;
                }
                txt3.setText(String.valueOf(result));
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame,"Please enter valid numbers");
            }
        };
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);
        frame.setVisible(true);
    }
}