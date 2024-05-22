import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws Exception {
        GregorianCalendar birthday = new GregorianCalendar(2003, 6, 17);
        Address address = new Address("Braila", 32, "Strada Pietatii");
        Client client = new Client("Frimu Aurel", birthday, "1234567890", address);
        CreditAccount c_acc = new CreditAccount("RORandomIBAN", 1500);
        CreditAccount c_acc2 = new CreditAccount("RandomIban3", 1200);
        CreditAccount c_acc3 = new CreditAccount("RandomIban4", 1200);
        CreditAccount c_acc4 = new CreditAccount("RandomIban5", 1200);
        DebitAccount d_acc = new DebitAccount("RORandomIBAN2", 2000);
        c_acc.setMaxCredit(1000);
        client.addAccount(c_acc);
        client.addAccount(d_acc);
        client.addAccount(c_acc2);
        client.addAccount(c_acc3);
        client.addAccount(c_acc4);

        client.removeAccount(c_acc3.getIBAN());

        System.out.println("Done");
        System.out.println(client.getFormattedBday());
        System.out.println(client.getCnp());
        System.out.println(client.getName());

        System.out.println(c_acc.getAmount());
        c_acc.withdraw(1000);
        System.out.println(c_acc.getAmount());
        c_acc.withdraw(1500);
        System.out.println(c_acc.getMaxCredit());
        c_acc.withdraw(1);
    }
}