import java.util.PriorityQueue;
// emergency queue class, for holding the emergencies

public class EmergencyQueue {
    private final PriorityQueue<Emergency> queue = new PriorityQueue<>();
    private final int maxSize;
    private int processed = 0;

    public EmergencyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    // synchronized functions
    public synchronized void addEmergency(Emergency emergency) throws InterruptedException {
        while (queue.size() == maxSize) {
            wait();
        }
        Logging.log(System.currentTimeMillis() + ": Attempting to add emergency: " + emergency);
        queue.add(emergency);
        Logging.log(System.currentTimeMillis() + ": Emergency added: " + emergency);
        notifyAll();
    }

    public synchronized Emergency getNextEmergency() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        Emergency emergency = queue.poll();
        processed++;
        if(processed == maxSize) {
            Logging.log(System.currentTimeMillis() + ": Queue is empty, exiting...");
            System.exit(0);
        }
        notifyAll();
        return emergency;
    }

}
