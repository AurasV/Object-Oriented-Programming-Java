import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Client {
    private String name;
    private GregorianCalendar bday;
    private String cnp;
    private List<Account> accounts = new ArrayList<>();
    private Address address;
    public Client(String name, GregorianCalendar bday, String cnp, Address address) {
        this.name = name;
        this.bday = bday;
        this.cnp = cnp;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getBday() {
        return bday;
    }

    public String getFormattedBday(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(bday.getTime());
    }
    public void setBday(GregorianCalendar bday) {
        this.bday = bday;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setCards(List<Account> cards) {
        this.accounts = cards;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addAccount(Account c){
        accounts.add(c);
    }

    public boolean removeAccount(String iban){
        Account cToRemove = null;
        for (Account c: accounts){
            if(c.getIBAN().equals(iban)){
                cToRemove = c;
                break;
            }
        }
        if(cToRemove != null){
            accounts.remove(cToRemove);
            return true;
        }
        return false;
    }
}
