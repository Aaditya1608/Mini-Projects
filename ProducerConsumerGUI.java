
import javax.swing.*;
import java.awt.*;

class Q {
    int n;
    boolean flag;

    private JTextArea output;

    Q(JTextArea output) {
        this.output = output;
    }
    private void println(String msg) {
        SwingUtilities.invokeLater(() -> output.append(msg + "\n"));
    }

    synchronized void put(int n) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                println("Interrupted Exception");
            }
        }
        println("PUT : " + n);
        this.n = n;
        flag = true;
        notify();
    }

    synchronized int get() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                println("Interrupted Exception");
            }
        }
        println("GOT : " + n);
        flag = false;
        notify();
        return n;
    }
}

class Producer extends Thread {
    Q q;
    volatile boolean running = true;

    Producer(Q q) {
        this.q = q;
    }

    public void stopProducer() {
        running = false;
    }

    public void run() {
        int n = 1;
        while (running) {
            q.put(n++);
            try { Thread.sleep(800); } catch (Exception e) {}
        }
    }
}

class Consumer extends Thread {
    Q q;
    volatile boolean running = true;

    Consumer(Q q) {
        this.q = q;
    }

    public void stopConsumer() {
        running = false;
    }

    public void run() {
        while (running) {
            q.get();
            try { Thread.sleep(800); } catch (Exception e) {}
        }
    }
}

public class ProducerConsumerGUI extends JFrame {

    JTextArea outputArea;
    JButton startBtn, stopBtn;

    Producer p;
    Consumer c;
    Q q;

    public ProducerConsumerGUI() {

        setTitle("Producer-Consumer Problem (Inter-thread Communication)");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Producer-Consumer Problem (Inter-Thread Communication)", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");

        panel.add(startBtn);
        panel.add(stopBtn);

        add(panel, BorderLayout.SOUTH);

        // Button listeners
        startBtn.addActionListener(e -> startThreads());
        stopBtn.addActionListener(e -> stopThreads());

        setVisible(true);
    }

    private void startThreads() {
        outputArea.setText("");

        q = new Q(outputArea);

        p = new Producer(q);
        c = new Consumer(q);

        p.start();
        c.start();

        outputArea.append("Producer & Consumer started...\n");
    }

    private void stopThreads() {
        if (p != null) p.stopProducer();
        if (c != null) c.stopConsumer();

        outputArea.append("\nStopped Producer & Consumer.\n");
    }

    public static void main(String[] args) {
        new ProducerConsumerGUI();
    }
}
