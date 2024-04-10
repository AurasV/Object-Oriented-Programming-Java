public class Main {
    public static void main(String[] args) {
        Bank b = new Bank();
        Person p1 = new Person("John", "Doe", "1234567890123");
        Person p2 = new Person("Jane", "Doe", "1234567890124");
        Loan l1 = new Loan(1, 1000, p1);
        Loan l2 = new Loan(2, 2000, p2);
        Loan l3 = new Loan(3, 3000, p1);
        b.addLoan(l1);
        b.addLoan(l2);
        b.addLoan(l3);
        System.out.println("All of John's loans ID and Amount:");
        b.find("John").forEach(l -> System.out.println(l.getId() + " " + l.getAmount()));
        System.out.println("All of John's loans ID and Amount with amount >= 1500:");
        b.find("John", 1500).forEach(l -> System.out.println(l.getId()+ " " + l.getAmount()));
        b.printInFile("loans.txt");
        System.out.println("Removed loan? " + b.remove(l2));
        b.printInFile("loans2.txt");

    }
}