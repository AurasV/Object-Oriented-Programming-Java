import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Bianca", "1234567890123", "Programmer", 1000, Calendar.getInstance());
        Employee employee2 = new Employee("Anda", "1234567890123", "Programmer", 1000, Calendar.getInstance());
        Employee employee3 = new Employee("Adi", "1234567890123", "Programmer", 1000, Calendar.getInstance());
        Employee employee4 = new Employee("Aurel", "1234567890123", "Programmer", 1000, Calendar.getInstance());
        Employee employee5 = new Employee("Teo", "1234567890123", "Programmer", 1000, Calendar.getInstance());
        Employee employee6 = new Employee("Steve", "1234567890123", "Programmer", 1000, Calendar.getInstance());
        Employee employee7 = new Employee("Johnut", "1234567890123", "Programmer", 1000, Calendar.getInstance());
        Employee employee8 = new Employee("David", "1234567890123", "Programmer", 1000, Calendar.getInstance());
        Employee employee9 = new Employee("Marcel", "1234567890123", "Programmer", 1000, Calendar.getInstance());
        Employee employee10 = new Employee("Marin", "1234567890123", "Programmer", 1000, Calendar.getInstance());

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
        employees.add(employee9);
        employees.add(employee10);

        HashMap<String, Employee> employeeHashMap = new HashMap<>();
        for (Employee e : employees) {
            employeeHashMap.put(e.getName(), e);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        if (employeeHashMap.containsKey(name)) {
            System.out.println(employeeHashMap.get(name));
        } else {
            System.out.println("Employee not found");
        }
    }
}