import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class Shape {
    int dim1, dim2;
    Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }
    abstract double getArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) { super(length, breadth); }
    double getArea() { return dim1 * dim2; }
}

class Triangle extends Shape {
    Triangle(int base, int height) { super(base, height); }
    double getArea() { return 0.5 * dim1 * dim2; }
}

class Circle extends Shape {
    Circle(int radius) { super(radius, 0); }
    double getArea() { return 3.14 * dim1 * dim1; }
}

public class ShapeGUI extends JFrame implements ActionListener {

    JComboBox<String> shapeList;
    JTextField dimField1, dimField2, areaField;
    JLabel label1, label2, areaLabel;
    JButton calcButton;

    ShapeGUI() {
        setTitle("Shape Area Calculator");
        setSize(250,420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        shapeList = new JComboBox<>(new String[]{"Rectangle", "Triangle", "Circle"});

        label1 = new JLabel("Dimension 1:");
        dimField1 = new JTextField(10);

        label2 = new JLabel("Dimension 2:");
        dimField2 = new JTextField(10);

        areaLabel = new JLabel("Area:");
        areaField = new JTextField(10);
        areaField.setEditable(false); 

        calcButton = new JButton("Calculate Area");
        calcButton.addActionListener(this);

        add(new JLabel("Select Shape:"));
        add(shapeList);
        add(label1);
        add(dimField1);
        add(label2);
        add(dimField2);
        add(areaLabel);
        add(areaField);
        add(calcButton);

        
        shapeList.addActionListener(e -> {
            if (shapeList.getSelectedItem().equals("Circle")) {
                label2.setVisible(false);
                dimField2.setVisible(false);
            } else {
                label2.setVisible(true);
                dimField2.setVisible(true);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String shape = (String) shapeList.getSelectedItem();

            int d1 = Integer.parseInt(dimField1.getText());
            int d2 = dimField2.isVisible() ? Integer.parseInt(dimField2.getText()) : 0;

            Shape obj;

            switch (shape) {
                case "Rectangle":
                    obj = new Rectangle(d1, d2);
                    break;
                case "Triangle":
                    obj = new Triangle(d1, d2);
                    break;
                default:
                    obj = new Circle(d1);
                    break;
            }

            double area = obj.getArea();
            areaField.setText(String.valueOf(area));  // Area in textbox

        } catch (NumberFormatException ex) {
            areaField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new ShapeGUI();
    }
}
