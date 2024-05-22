import java.util.Calendar;
public class Employee {
    private String name;
    private String CNP;
    private String specialization;
    private float salary;
    private Calendar hiringDate;

    public Employee(String name, String CNP, String specialization, float salary, Calendar hiringDate) {
        this.name = name;
        this.CNP = CNP;
        this.specialization = specialization;
        this.salary = salary;
        this.hiringDate = hiringDate;
    }

    @Override
    public String toString() {
        return  "name='" + this.name + '\'' +
                ", CNP='" + this.CNP + '\'' +
                ", hiringDate=" + this.hiringDate +
                ", specialization='" + this.specialization + '\'' +
                ", salary=" + this.salary;
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
