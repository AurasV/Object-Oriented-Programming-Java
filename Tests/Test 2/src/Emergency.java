// emergency class, for creating emergencies
public class Emergency implements Comparable<Emergency> {
    private final String callerId;
    private final String location;
    private final String description;
    private final Urgency urgency;
    private final long timestamp;

    public Emergency(String callerId, String location, String description, Urgency urgency) {
        this.callerId = callerId;
        this.location = location;
        this.description = description;
        this.urgency = urgency;
        this.timestamp = System.currentTimeMillis();
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public long getTimestamp() {
        return timestamp;
    }

    // processing high urgency emergencies takes priority over medium and low urgency emergencies
    @Override
    public int compareTo(Emergency other) {
        if (this.urgency != other.urgency) {
            return this.urgency.ordinal() - other.urgency.ordinal();
        }
        return Long.compare(this.timestamp, other.timestamp);
    }

    @Override
    public String toString() {
        return "Emergency{" +
                "callerId='" + callerId + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", urgency=" + urgency +
                ", timestamp=" + timestamp +
                '}';
    }
}

// urgency enum
enum Urgency {
    HIGH, MEDIUM, LOW
}
