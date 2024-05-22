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
}
