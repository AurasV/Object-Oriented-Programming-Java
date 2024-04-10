import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class SensorSystem extends JFrame {
    private final List<Sensor> sensors = new ArrayList<>();
    private final JTextArea textArea = new JTextArea(20, 40);
    private final EventQueue eventQueue = new EventQueue();
    private Dispatcher dispatcher;
    private Thread dispatcherThread;

    public SensorSystem() {
        initializeSensorsAndDispatcher();

        textArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);

        setTitle("Sensor Control System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void initializeSensorsAndDispatcher() {
        for (int i = 0; i < 4; i++) {
            Sensor sensor = new Sensor("Sensor" + i, eventQueue);
            Thread sensorThread = new Thread(sensor);
            sensorThread.start();
            sensors.add(sensor);
        }

        dispatcher = new Dispatcher(eventQueue, textArea);
        dispatcherThread = new Thread(dispatcher);
        dispatcherThread.start();
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        for (int i = 0; i < 4; i++) {
            final int sensorIndex = i;
            final Sensor sensor = sensors.get(sensorIndex);
            JButton button = new JButton(sensor.isActive() ? "Pause Sensor " + sensorIndex : "Start Sensor " + sensorIndex);
            button.addActionListener((ActionEvent e) -> {
                sensor.setActive(!sensor.isActive());
                button.setText(sensor.isActive() ? "Pause Sensor " + sensorIndex : "Start Sensor " + sensorIndex);
            });
            panel.add(button);
        }
        return panel;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SensorSystem().setVisible(true));
    }

    // Sensor class
    static class Sensor implements Runnable {
        private final String sensorId;
        private final EventQueue eventQueue;
        private final Random random = new Random();
        private volatile boolean active = true;

        public Sensor(String sensorId, EventQueue eventQueue) {
            this.sensorId = sensorId;
            this.eventQueue = eventQueue;
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(1000));
                    if (active) {
                        String eventType = "EventType" + random.nextInt(10);
                        SensorEvent event = new SensorEvent(sensorId, eventType);
                        eventQueue.addEvent(event);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public boolean isActive() {
            return active;
        }
    }

    static class SensorEvent {
        private final String sensorId;
        private final long timeStamp;
        private final String eventType;

        public SensorEvent(String sensorId, String eventType) {
            this.sensorId = sensorId;
            this.timeStamp = System.currentTimeMillis();
            this.eventType = eventType;
        }

        public String toString() {
            return "SensorEvent{" +
                    "sensorId='" + sensorId + '\'' +
                    ", timeStamp=" + timeStamp +
                    ", eventType='" + eventType + '\'' +
                    '}';
        }
    }

    static class EventQueue {
        private final LinkedBlockingQueue<SensorEvent> queue = new LinkedBlockingQueue<>();
        private final ReentrantLock lock = new ReentrantLock();

        public void addEvent(SensorEvent event) {
            lock.lock();
            try {
                queue.add(event);
            } finally {
                lock.unlock();
            }
        }

        public SensorEvent takeEvent() throws InterruptedException {
            return queue.take();
        }
    }

    static class Dispatcher implements Runnable {
        private final EventQueue eventQueue;
        private final JTextArea textArea;

        public Dispatcher(EventQueue eventQueue, JTextArea textArea) {
            this.eventQueue = eventQueue;
            this.textArea = textArea;
        }

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    SensorEvent event = eventQueue.takeEvent();
                    Thread.sleep(50);
                    SwingUtilities.invokeLater(() -> textArea.append("Event processed: " + event + "\n"));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
