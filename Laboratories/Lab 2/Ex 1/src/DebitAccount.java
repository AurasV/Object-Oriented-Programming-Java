import java.io.FileWriter;
import java.io.IOException;

public class DebitAccount extends Account {


    public DebitAccount(String IBAN, int amount) {
        super(IBAN, amount);
    }

    @Override
    public void withdraw(int sum) throws Exception{
        if(sum > getAmount())
            throw new Exception("Not Enough funds!");
        else
            setAmount(getAmount() - sum);
    }

    @Override
    public void deposit(int sum) {
        setAmount(getAmount() + sum);
    }


    @Override
    public int compareTo(Account o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == o) return EQUAL;
        if(this.getIBAN().compareTo(o.getIBAN()) < 0) return BEFORE;
        if(this.getIBAN().compareTo(o.getIBAN()) > 0) return AFTER;

        return EQUAL;
    }

    @Override
    public void Store(String file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("IBAN: " + this.getIBAN() + "\n");
            writer.write("Amount: " + this.getAmount() + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
