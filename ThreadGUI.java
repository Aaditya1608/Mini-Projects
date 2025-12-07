import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ThreadGUI extends JFrame {

    JTextArea outputArea;
    JButton startBtn, stopBtn;

    NumberGenerator generatorThread;   // reference to the generator thread
    volatile boolean running = false;  // flag to control thread

    public ThreadGUI() {
        setTitle("Multi-Threaded Number Processor");
        setSize(500, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Multi threaded Number Processor", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Buttons Panel
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());

        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");

        btnPanel.add(startBtn);
        btnPanel.add(stopBtn);
        add(btnPanel, BorderLayout.SOUTH);

        // Button actions
        startBtn.addActionListener(e -> startGenerating());
        stopBtn.addActionListener(e -> stopGenerating());

        setVisible(true);
    }

    // Thread-safe print
    private void println(String msg) {
        SwingUtilities.invokeLater(() -> outputArea.append(msg + "\n"));
    }

    // Start the generator thread
    private void startGenerating() {
        outputArea.setText("");
        if (running) {
            println("Already Running...");
            return;
        }
        running = true;

        println("Starting Number Generation...\n");

        generatorThread = new NumberGenerator();
        generatorThread.start();
    }

    // Stop the generator thread
    private void stopGenerating() {
        if (!running) {
            println("Already Stopped.");
            return;
        }
        running = false;
        println("\nNumber Generation Stopped.\n");
    }

    // Thread 1: Number Generator
    class NumberGenerator extends Thread {
        Random rand = new Random();

        public void run() {
            while (running) {
                int num = rand.nextInt(100)+1;
                println("Generated Number: " + num);

                if (num % 2 == 0) {
                    new SquareThread(num).start();
                } else {
                    new CubeThread(num).start();
                }

                try { Thread.sleep(1000); }
                catch (InterruptedException e) {}
            }
        }
    }

    // Thread 2: Square
    class SquareThread extends Thread {
        int number;

        SquareThread(int number) { this.number = number; }

        public void run() {
            int square = number * number;
            println("Even -> Square: " + square);
        }
    }

    // Thread 3: Cube
    class CubeThread extends Thread {
        int number;

        CubeThread(int number) { this.number = number; }

        public void run() {
            int cube = number * number * number;
            println("Odd -> Cube: " + cube);
        }
    }

    public static void main(String[] args) {
        new ThreadGUI();
    }
}
