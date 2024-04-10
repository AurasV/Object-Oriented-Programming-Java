public class Person {
    private String name;
    private String surname;
    private String CNP;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Person(String name, String surname, String CNP) {
        this.name = name;
        this.surname = surname;
        this.CNP = CNP;
    }
}
