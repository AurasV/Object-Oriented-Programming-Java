import java.util.*;

public class Event {
    public enum TYPE {AQUARIUM, CIRCUS, CONCERT, MOVIE, MUSEUM, OTHER, PARK, SHOW, THEATER, ZOO }
    private String location;
    private final TYPE type;
    private int price;
    private Calendar startDate;
    private Calendar endDate;

    public Event(String location, TYPE type, int price, Calendar startDate, Calendar endDate) {
        this.location = location;
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Map<TYPE, List<Client>> getClientsByType(List<Client> clients) {
        Map<TYPE, List<Client>> map = new HashMap<>();
        if(clients == null || clients.isEmpty())
            throw new IllegalArgumentException("Clients list is null or empty");
        else {
            for (Client client : clients) {
                for (Event event : client.getEvents()) {
                    if (map.containsKey(event.getType())) {
                        List<Client> list = map.get(event.getType());
                        list.add(client);
                        map.put(event.getType(), list);
                    } else {
                        List<Client> list = new ArrayList<>();
                        list.add(client);
                        map.put(event.getType(), list);
                    }
                }
            }
        }
        return map;
    }


    @Override
    public String toString() {
        return "location = '" + location + "' type = '" + type  + "' price = " + price + "' startDate = '" + startDate.getTime() + "' endDate = '" + endDate.getTime() + "'\n";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TYPE getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
}
