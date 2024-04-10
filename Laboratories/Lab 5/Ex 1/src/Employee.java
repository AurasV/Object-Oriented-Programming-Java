import java.util.Calendar;
import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String name;
    private String CNP;
    private String specialization;
    private float salary;
    private Calendar hiringDate;

    //reimplement HashSet to depend only on the values of the fields
    @Override
    public int hashCode() {
        return Objects.hash(name, CNP, hiringDate, specialization, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(CNP, employee.CNP) &&
                Objects.equals(hiringDate, employee.hiringDate) &&
                Objects.equals(specialization, employee.specialization);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", CNP='" + CNP + '\'' +
                ", hiringDate=" + hiringDate +
                ", specialization='" + specialization + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }

        int cnpComparison = this.CNP.compareTo(other.CNP);
        if (cnpComparison != 0) {
            return cnpComparison;
        }

        int hiringDateComparison = this.hiringDate.compareTo(other.hiringDate);
        if (hiringDateComparison != 0) {
            return hiringDateComparison;
        }

        int specializationComparison = this.specialization.compareTo(other.specialization);
        if (specializationComparison != 0) {
            return specializationComparison;
        }

        if (this.salary != other.salary) {
            return Float.compare(this.salary, other.salary);
        }

        return 0;
    }

    public Employee(String name, String CNP, String specialization, float salary, Calendar hiringDate) {
        this.name = name;
        this.CNP = CNP;
        this.specialization = specialization;
        this.salary = salary;
        this.hiringDate = hiringDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Calendar getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Calendar hiringDate) {
        this.hiringDate = hiringDate;
    }
}
