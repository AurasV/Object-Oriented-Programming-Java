public class Main {
    public static void main(String[] args) {
        Contract contract = new Contract();

        contract.addCourse(new Course("Course A", 15, Course.Stream.English, Course.Type.Foundamental));
        contract.addCourse(new Course("Course B", 12, Course.Stream.French, Course.Type.Foundamental));
        contract.addCourse(new Course("Course C", 4, Course.Stream.German, Course.Type.Specialization));
        contract.addCourse(new Course("Course D", 3, Course.Stream.English, Course.Type.Specialization));
        contract.addCourse(new Course("Course E", 2, Course.Stream.French, Course.Type.Discipline));

        System.out.println("Unsorted Courses:");
        contract.display();

        contract.sort();

        System.out.println("\nSorted Courses:");
        contract.display();

        contract.deleteCourse(Course.Type.Discipline, Course.Stream.French, "Course E");

        System.out.println("\nCourses after deleting " + "Course E" + ":");
        contract.display();

        contract.store("courses.txt");

        contract.addCourse(new Course("Course A", 15, Course.Stream.English, Course.Type.Foundamental));
        contract.sort();
    }
}
