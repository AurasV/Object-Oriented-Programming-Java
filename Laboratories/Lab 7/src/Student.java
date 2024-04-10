import java.util.List;

public class Student {
    private int studentId;
    private String name;
    private String group;
    private List<Course> courses;

    public Student(int studentId, String name, String group, List<Course> courses) {
        this.studentId = studentId;
        this.name = name;
        this.group = group;
        this.courses = courses;
        for (Course course : this.courses) {
            course.addStudent(this);
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", courses=" + courses +
                '}' + "\n";
    }
}
