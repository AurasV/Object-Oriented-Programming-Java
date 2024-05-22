public abstract class Account {
    private String IBAN;
    private int amount;
    public Account(String IBAN, int amount) {
        this.IBAN = IBAN;
        this.amount = amount;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public abstract void withdraw(int sum) throws Exception;
    public abstract void deposit(int sum);
}
