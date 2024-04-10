public class Test {
    public static void main(String[] args) {
        Truck x = new Truck(1500, "Truck USA", "USA", "Ford");
        System.out.println(x.toString());
        System.out.println("----------------------------------");
        Bus y = new Bus(1500, "Bus Germany", "Germany", "Volkswagen");
        System.out.println(y.toString());
        System.out.println("----------------------------------");
        Minibus z = new Minibus(1500, "Minibus Italy", "Italy", "Lamborghini");
        System.out.println(z.toString());
        System.out.println("----------------------------------");
        Truck t = new Truck(1500, "Truck Romania", "RO", "Dacia");
        System.out.println(t.toString());
        System.out.println("----------------------------------");

        System.out.println(x.getName() + " compared to " + y.getName() + ": " + x.compareTo(y));
        System.out.println(x.getName() + " compared to " + z.getName() + ": " + x.compareTo(z));
        System.out.println(x.getName() + " compared to " + t.getName() + ": " + x.compareTo(t));
        System.out.println("----------------------------------");
        System.out.println(y.getName() + " compared to " + x.getName() + ": " + y.compareTo(x));
        System.out.println(y.getName() + " compared to " + z.getName() + ": " + y.compareTo(z));
        System.out.println(y.getName() + " compared to " + t.getName() + ": " + y.compareTo(t));
        System.out.println("----------------------------------");
        System.out.println(z.getName() + " compared to " + x.getName() + ": " + z.compareTo(x));
        System.out.println(z.getName() + " compared to " + y.getName() + ": " + z.compareTo(y));
        System.out.println(z.getName() + " compared to " + t.getName() + ": " + z.compareTo(t));
        System.out.println("----------------------------------");
        System.out.println(t.getName() + " compared to " + x.getName() + ": " + t.compareTo(x));
        System.out.println(t.getName() + " compared to " + y.getName() + ": " + t.compareTo(y));
        System.out.println(t.getName() + " compared to " + z.getName() + ": " + t.compareTo(z));

    }
}