import java.util.ArrayList;
import java.util.Comparator;


public class Client {
    private String name;
    private String email;
    private ArrayList<Event> events = new ArrayList<Event>();

    public void buyEvent(Event event) {
        if(events.contains(event))
            throw new IllegalArgumentException("Event already bought");
        else
            events.add(event);
    }

    public void showAllEventsByPrice(){
        ArrayList<Event> events2 = events;
        events2.sort(Comparator.comparingInt(Event::getPrice));
        System.out.println(events2);
    }

    @Override
    public String toString() {
        return "Client -> " +
                "name = '" + name + "' email = '" + email  + "'\n";
    }

    public void showAllEventsByType(){
        ArrayList<Event> events2 = events;
        events.sort(Comparator.comparing(Event::getType));
        System.out.println(events2);
    }

    public void showAllEventsUnordered(){
        System.out.println(events);
    }
    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
