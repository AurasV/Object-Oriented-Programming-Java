public class Loan {
    private int id;
    private double amount;
    private Person owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Loan(int id, double amount, Person owner) {
        this.id = id;
        this.amount = amount;
        this.owner = owner;
    }

    public void increaseAmount(double added){
        this.amount += added;
    }
}
