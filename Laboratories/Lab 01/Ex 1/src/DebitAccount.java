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
}
