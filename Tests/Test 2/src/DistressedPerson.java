// distressed person class, for creating a new emergency and adding it to the queue
public class DistressedPerson extends Thread {
    private final EmergencyQueue queue;
    private final String callerId;
    private final String location;
    private final String description;

    public DistressedPerson(EmergencyQueue queue, String callerId, String location, String description) {
        this.queue = queue;
        this.callerId = callerId;
        this.location = location;
        this.description = description;
    }

    @Override
    public void run() {
        try { // try to create + add an emergency to the queue with random urgency
            Emergency emergency = new Emergency(
                    callerId,
                    location,
                    description,
                    Urgency.values()[(int) (Math.random() * Urgency.values().length)]
            );
            queue.addEmergency(emergency);
        } catch (Exception e) { // catching errors and displaying, mostly for debugging
            Logging.log(String.valueOf(e));
        }
    }
}
