import javax.swing.*;
import java.awt.*;


public class ExceptionDemoGUI extends JFrame {

    JTextArea outputArea;

    public ExceptionGUI() {
        setTitle("Exception Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

      
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 10, 10));

        JButton btn1 = new JButton("With Exception");
        JButton btn2 = new JButton("No Exception");
        JButton btn3 = new JButton("With Return");

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);

        add(panel, BorderLayout.SOUTH);

        
        btn1.addActionListener(e -> withException());
        btn2.addActionListener(e -> noException());
        btn3.addActionListener(e -> withReturn());
    }

    
    private void println(String text) {
        outputArea.append(text + "\n");
    }

   
    public void withException() {
        outputArea.setText("");
        try {
            println("Try of WithException");
            int x = 10 / 0;
        }
        catch(Exception e) {
            println("Catch of WithException");
        }
        finally {
            println("Final of WithException");
        }
    }

    public void noException() {
        outputArea.setText("");
        try {
            println("Try of noException");
            int x = 10 / 2;
        }
        catch(Exception e) {
            println("Catch of noException");
        }
        finally {
            println("Final of noException");
        }
    }

    public void withReturn() {
        outputArea.setText("");
        try {
            println("Try of withReturn");
            return;
        }
        catch(Exception e) {
            println("Catch of withReturn");
        }
        finally {
            println("Final of withReturn");
        }
    }

    public static void main(String[] args) {
        new ExceptionGUI().setVisible(true);
    }
}
