import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
A company organizes team building events.
Each event has a start date, end date, price, type and location.
Clients (name, email) buy events which are added to their purchases.
Check when adding events that they do not overlap.
Clients can display their purchased events, sorted by their price or by their type.

Also given the collection of clients implement a method that returns

Map<Event.TYPE,List<Client>> - where Event.TYPE is an enumeration representing the types of events.
This map contains the list of clients for each type of events.
*/

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("John", "john@gmail.com");
        Client client2 = new Client("Mary", "mary@gmail.com");
        Client client3 = new Client("Peter", "peter@gmail.com");

        List<Client> clients = new ArrayList<>();
        List<Client> clients2 = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        Event event1 = new Event("São Paulo", Event.TYPE.CIRCUS, 400, startDate, endDate);

        Event event2 = new Event("Los Angeles", Event.TYPE.SHOW, 200, startDate, endDate);

        Event event3 = new Event("Bucharest", Event.TYPE.AQUARIUM   , 300, startDate, endDate);

        client2.buyEvent(event2);
        client3.buyEvent(event3);

        client1.buyEvent(event1);
        client1.buyEvent(event2);
        client1.buyEvent(event3);

        System.out.println("Unordered Events for client 1:");
        client1.showAllEventsUnordered();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Ordered by Price Events for client 1:");
        client1.showAllEventsByPrice();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Ordered by Type Events for client 1:");
        client1.showAllEventsByType();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Clients by Type:");
        System.out.println(event1.getClientsByType(clients));
        System.out.println("---------------------------------------------------------------------------------------------");

        System.out.println("Client 1 buys event 1 again:");
        client1.buyEvent(event1);

        System.out.println("Clients by Type with empty List:");
        System.out.println(event1.getClientsByType(clients2));
    }
}