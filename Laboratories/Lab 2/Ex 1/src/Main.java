import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws Exception {
        GregorianCalendar birthday = new GregorianCalendar(2003, 6, 17);
        Address address = new Address("Braila", 32, "Strada Pietatii");
        Client client = new Client("Frimu Aurel", birthday, "1234567890", address);
        CreditAccount c_acc = new CreditAccount("1234B", 1500);
        CreditAccount c_acc2 = new CreditAccount("1234B", 1200);
        CreditAccount c_acc3 = new CreditAccount("1234C", 1200);
        CreditAccount c_acc4 = new CreditAccount("1234A", 1200);
        DebitAccount d_acc = new DebitAccount("0123", 2000);
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
        System.out.println("Comparing first IBAN to 2nd");
        System.out.println(c_acc.compareTo(c_acc2));
        System.out.println("Comparing first IBAN to 3rd");
        System.out.println(c_acc.compareTo(c_acc3));
        System.out.println("Comparing first IBAN to 4th");
        System.out.println(c_acc.compareTo(c_acc4));
        System.out.println("Comparing first IBAN to 5th");
        System.out.println(c_acc.compareTo(d_acc));
        c_acc.Store("acc1.txt");
        c_acc2.Store("acc2.txt");
        c_acc3.Store("acc3.txt");
        c_acc4.Store("acc4.txt");
        d_acc.Store("acc5.txt");

        c_acc.withdraw(1);


    }
}