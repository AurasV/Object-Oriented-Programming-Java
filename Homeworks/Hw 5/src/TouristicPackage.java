import java.util.List;

public class TouristicPackage {
    private String name;
    private int id;
    private double price;
    private List<Attraction> attractions;

    public TouristicPackage(String name, int id, double price, List<Attraction> attractions) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.attractions = attractions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
}
