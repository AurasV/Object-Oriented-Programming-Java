import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Employee employee1 = new Employee("Employee", "1234567890123", "Specialization", 1000, calendar);
        Employee employee2 = new Employee("Employee", "1234567890123", "Specialization", 1000, calendar);
        Employee employee3 = new Employee("Employee", "1234567890123", "Specialization2", 1000, Calendar.getInstance());
        Employee employee4 = new Employee("Employee", "1234567890123", "Specialization3", 1000, Calendar.getInstance());
        Employee employee5 = new Employee("Employee", "1234567890123", "Specialization4", 1000, Calendar.getInstance());
        Employee employee6 = new Employee("Employee", "1234567890123", "Specialization5", 1000, Calendar.getInstance());
        Employee employee7 = new Employee("Employee", "1234567890123", "Specialization6", 1000, Calendar.getInstance());
        Employee employee8 = new Employee("Employee", "1234567890123", "Specialization7", 1000, Calendar.getInstance());
        Employee employee9 = new Employee("Employee", "1234567890123", "Specialization8", 1000, Calendar.getInstance());
        Employee employee10 = new Employee("Employee", "1234567890123", "Specialization9", 1000, Calendar.getInstance());
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
        employees.add(employee9);
        employees.add(employee10);

        System.out.println("Use Iterator to parse and display list:");
        for (Employee employee : employees) {
            System.out.println(employee.getSpecialization());
        }

        System.out.println("------------------------------------");

        System.out.println("Use ListIterator to parse and display list backwards and add an element to the middle of the list:");
        ListIterator<Employee> listIterator = employees.listIterator(employees.size());
        while (listIterator.hasPrevious()) {
            Employee employee = listIterator.previous();
            if(listIterator.previousIndex() == 4 && employees.size() <= 10){
                listIterator.add(new Employee("Employee", "1234567890123", "Specialization10", 1000, Calendar.getInstance()));
            }
            System.out.println(employee.getSpecialization());
        }


        System.out.println("------------------------------------");

        System.out.println("Add all employees to HashSet:");
        HashSet<Employee> employeesHashSet = new HashSet<>(employees);
        System.out.println("Employees added to HashSet");

        System.out.println("------------------------------------");

        System.out.println("Use Iterator to parse HashSet");
        for (Employee employee : employeesHashSet) {
            System.out.println(employee.getSpecialization());
        }

        System.out.println("------------------------------------");

        System.out.println("Use reimplemented HashSet");
        HashSet<Employee> employeesHashSet2 = new HashSet<>(employees);
        System.out.println("Employees added to reimplemented HashSet");

        System.out.println("------------------------------------");

        System.out.println("Use Iterator to parse reimplemented HashSet");
        Iterator<Employee> iterator2 = employeesHashSet2.iterator();
        while (iterator2.hasNext()) {
            Employee employee = iterator2.next();
            System.out.println(employee.getSpecialization());
        }

        System.out.println("------------------------------------");

        System.out.println("Add all employees to TreeSet:");
        TreeSet<Employee> employeesTreeSet = new TreeSet<>(employees);
        System.out.println("Employees added to TreeSet");

        System.out.println("------------------------------------");

        System.out.println("Use Iterator to parse TreeSet");
        Iterator<Employee> iterator = employeesTreeSet.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee.getSpecialization());
        }
    }
}