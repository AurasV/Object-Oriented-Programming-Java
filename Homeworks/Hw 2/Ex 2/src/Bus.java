public class Bus extends Vehicle{
    private String manufacturer;


    public Bus(double basePrice, String name, String country, String manufacturer) {
        super(basePrice, name, country);
        this.manufacturer = manufacturer;
    }

    @Override
    public double computeRoadTax() {
        double roadTax = getBasePrice() * 0.04;
        return roadTax;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        String show = "";
        show += "Base Price: " + this.getBasePrice();
        show += "\nName: " + this.getName();
        show += "\nCountry: " + this.getCountry();
        show += "\nManufacturer: " + this.getManufacturer();
        show += "\nTotal Tax: " + this.computeTotalTax();
        return show;
    }

    @Override
    public int compareTo(Vehicle o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this.computeTotalTax() == o.computeTotalTax())
            if(this.getBasePrice() > o.getBasePrice())
                return BEFORE;
            else if(this.getBasePrice() == o.getBasePrice())
                return EQUAL;
            else
                return AFTER;
        else if(this.computeTotalTax() < o.computeTotalTax())
            return BEFORE;
        else
            return AFTER;

    }
}
