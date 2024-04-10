import java.util.Objects;

public abstract class Vehicle implements Taxable, Comparable<Vehicle> {
    private double basePrice;
    private String name;
    private String country;

    public Vehicle(double basePrice, String name, String country) {
        this.basePrice = basePrice;
        this.name = name;
        this.country = country;
    }

    public double computeVAT(){
        double VAT = getBasePrice() * 0.19;
        return VAT;
    }

    public abstract double computeRoadTax();

    public double computeCustomTax(){
        double customTax = 0;
        if((!this.getCountry().equalsIgnoreCase("romania")) && (!this.getCountry().equalsIgnoreCase("ro")))
            customTax = getBasePrice() * 0.1;
        return customTax;
    }

    public double computeTotalTax(){
        double totalTax = computeVAT() + computeRoadTax() + computeCustomTax();
        return totalTax;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
