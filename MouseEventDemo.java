import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends JFrame implements MouseListener {

    String message = "Perform Mouse Action";
    int x = 0, y = 0;

    public MouseEventDemo() {
        setTitle("Mouse Event Handling Demo");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Register mouse listener
        addMouseListener(this);
    }

    // Paint method to display messages
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString(message, x, y);
    }

    // Mouse Clicked
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        message = "Mouse Clicked at (" + x + ", " + y + ")";
        repaint();
    }

    // Mouse Entered
    public void mouseEntered(MouseEvent e) {
        x = 100;
        y = 100;
        message = "Mouse Entered the Window";
        repaint();
    }

    // Mouse Exited
    public void mouseExited(MouseEvent e) {
        x = 100;
        y = 120;
        message = "Mouse Exited the Window";
        repaint();
    }

    // Mouse Pressed
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        message = "Mouse Pressed at (" + x + ", " + y + ")";
        repaint();
    }

    // Mouse Released
    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        message = "Mouse Released at (" + x + ", " + y + ")";
        repaint();
    }

    public static void main(String[] args) {
        new MouseEventDemo();
    }
}
