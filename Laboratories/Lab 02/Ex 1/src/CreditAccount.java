import java.io.FileWriter;
import java.io.IOException;

public class CreditAccount extends Account{

    private int maxCredit = 0;
    public CreditAccount(String IBAN, int amount) {
        super(IBAN, amount);
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(int maxCredit) {
        this.maxCredit = maxCredit;
    }


    @Override
    public void withdraw(int sum) throws Exception {
        if(sum > (getAmount() + getMaxCredit()))
            throw new Exception("Not enough funds");
        else if (sum > getAmount()) {
            sum = sum - getAmount();
            setAmount(0);
            setMaxCredit(getMaxCredit() - sum);
        }
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
            writer.write("Max Credit: " + this.getMaxCredit() + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
