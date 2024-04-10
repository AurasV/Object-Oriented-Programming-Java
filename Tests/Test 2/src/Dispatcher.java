// dispatcher class, for processing the emergencies in the queue
public class Dispatcher extends Thread {
    private final EmergencyQueue queue;

    public Dispatcher(EmergencyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Emergency emergency = queue.getNextEmergency();
                Logging.log(System.currentTimeMillis() + ": Starting to process emergency: " + emergency);
                // small delay for processing time (not necessary, but it simulates real world)
                Thread.sleep(1000);
                Logging.log(System.currentTimeMillis() + ": Finished processing emergency: " + emergency);
            }
        } catch (Exception e) {
            Logging.log(String.valueOf(e));
        }
    }
}
