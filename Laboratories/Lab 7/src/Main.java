import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // Receive a list of integers, remove odd elements, square each remaining element,
    // collect the result in a new list. (hint use filter and map)
    public static List<Integer> exercise1(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Receive a list of integers, return the sum of squares (hint use map and reduce)
    public static Integer exercise2(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);
    }

    // Receive a list of Strings, return a map that has as key the string
    // length and as value the number of strings with that length.
    // Provide 2 solutions (exercise3a, exercise3b)
    public static Map<Integer, Long> exercise3a(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        String::length,
                        s -> 1L,
                        Long::sum));
    }

    public static Map<Integer, Long> exercise3b(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    // Receive a list of lists of Strings, return a list
    // with all the distinct words. (hint use flatmap)
    public static List<String> exercise4(List<List<String>> list) {
        return list.stream()
                .flatMap(l -> l.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    // Receive a list of students and a group.
    // Retain only the students from the given group,
    // return a string containing their comma-separated names ( hint use Collectors.joining)
    public static String exercise5(List<Student> students, String group) {
        return students.stream()
                .filter(s -> s.getGroup().equals(group))
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }

    // Generate a large list of integers (over 100.000).
    // Compute the sum of their squares.
    // Compare the execution time of using parallel streams and sequential streams.
    public static String exercise6() {
        double size = 100000;
        List<Integer> numbers_list = new ArrayList<>();
        Random random = new Random();
        for (double i = 0; i < size; i++) {
            numbers_list.add(random.nextInt(100));
        }

        StringBuilder result = new StringBuilder();

        long startTime = System.currentTimeMillis();
        long sumSequential = numbers_list.stream()
                .mapToLong(i -> (long) i * i)
                .sum();
        long endTime = System.currentTimeMillis();
        result.append("Sum using Sequential Stream: ").append(sumSequential)
                .append("\nTime taken with Sequential Stream: ").append(endTime - startTime).append(" ms\n");

        startTime = System.currentTimeMillis();
        long sumParallel = numbers_list.parallelStream()
                .mapToLong(i -> (long) i * i)
                .sum();
        endTime = System.currentTimeMillis();
        result.append("Sum using Parallel Stream: ").append(sumParallel)
                .append("\nTime taken with Parallel Stream: ").append(endTime - startTime).append(" ms");

        return result.toString();
    }

    // Receive a list of students.
    // Return the list of students enrolled in courses that have over 5 credit points.
    public static List<Student> exercise7(List<Student> students) {
        return students.stream()
                .filter(s -> s.getCourses().stream()
                        .anyMatch(c -> c.getCreditPoints() > 5))
                .collect(Collectors.toList());
    }

    // Receive a list of students.
    // Return the list of students enrolled in courses that in total have over 30 credit points.
    public static List<Student> exercise8(List<Student> students) {
        return students.stream()
                .filter(s -> s.getCourses().stream()
                        .mapToInt(Course::getCreditPoints)
                        .sum() > 30)
                .collect(Collectors.toList());
    }

    // Receive a list of courses. Return a map where the key
    // is the course id and the value is the list of ids of
    // the students enrolled in that course.
    public static Map<Integer, List<Integer>> exercise9(List<Course> courses) {
        return courses.stream()
                .collect(Collectors.toMap(
                        Course::getCourseId,
                        c -> c.getStudents().stream()
                                .map(Student::getStudentId)
                                .collect(Collectors.toList())));
    }

    // Receive a list of students and a group.
    // Return the list of the first 5 students in the group, sorted by name.
    public static List<Student> exercise10(List<Student> students, String group) {
        return students.stream()
                .filter(s -> s.getGroup().equals(group))
                .sorted(Comparator.comparing(Student::getName))
                .limit(5)
                .collect(Collectors.toList());
    }

    // Receive a list of students.
    // Return a map where the key is the group and
    // the value is the list of courses in which the
    // students from the group are enrolled, with duplicates removed.
    public static Map<String, List<Course>> exercise11(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.flatMapping(
                                s -> s.getCourses().stream(),
                                Collectors.toSet())))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> new ArrayList<>(e.getValue())));
    }


    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        System.out.println("Exercise 1: ");
        System.out.println("Input for exercise 1: " + input);
        System.out.println("\nOutput for exercise 1: \n");
        List<Integer> output = exercise1(input);
        System.out.println(output);

        System.out.println("--------------------------------------------------------------");

        List<Integer> input2 = List.of(1, 2, 3, 4, 5);
        System.out.println("Exercise 2: ");
        System.out.println("Input for exercise 2: " + input2);
        System.out.println("\nOutput for exercise 2: \n");
        Integer output2 = exercise2(input2);
        System.out.println(output2);

        System.out.println("--------------------------------------------------------------");

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println("Exercise 3a: ");
        System.out.println("Input for exercise 3a: " + strings);
        System.out.println("\nOutput for exercise 3a: \n");
        Map<Integer, Long> result = exercise3a(strings);
        System.out.println(result);

        System.out.println("--------------------------------------------------------------");

        System.out.println("Exercise 3b: ");
        System.out.println("Input for exercise 3b: " + strings);
        System.out.println("\nOutput for exercise 3b: \n");
        Map<Integer, Long> result2 = exercise3b(strings);
        System.out.println(result2);

        System.out.println("--------------------------------------------------------------");

        List<List<String>> input3 = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("apple", "cherry"),
                Arrays.asList("banana", "date"));
        System.out.println("Exercise 4: ");
        System.out.println("Input for exercise 4: " + input3);
        System.out.println("\nOutput for exercise 4: \n");
        List<String> output3 = exercise4(input3);
        System.out.println(output3);

        Course english = new Course(1, 7, 1, "English");
        Course spanish = new Course(2, 8, 1, "Spanish");
        Course french  = new Course(3, 9, 1, "French");
        Course math = new Course(4, 10, 1, "Math");
        Course physics = new Course(5, 11, 1, "Physics");
        Course chemistry = new Course(6, 12, 1, "Chemistry");
        Course russian = new Course(13, 13, 1, "Russian");
        Course business = new Course(14, 14, 1, "Business");
        Course accounting = new Course(15, 15, 1, "Accounting");

        Student ion = new Student(1, "Ion", "A", Arrays.asList(english, spanish, french));
        Student maria = new Student(2, "Maria", "A", Arrays.asList(physics, math, chemistry));
        Student marcel = new Student(3, "Marcel", "A", Arrays.asList(math, english, french));
        Student albert = new Student(4, "Albert", "A", Arrays.asList(math, english, french));
        Student tom = new Student(5, "Tom", "A", Arrays.asList(russian, business, accounting));
        Student john = new Student(6, "John", "A", Arrays.asList(english, spanish, french));
        // group A distinct courses -> english, spanish, french, physics, math, chemistry, russian, business, accounting
        Student ana = new Student(7, "Ana", "B", Arrays.asList(physics, math, chemistry));
        Student alex = new Student(8, "Alex", "B", Arrays.asList(math, english, french));
        Student diana = new Student(9, "Diana", "B", Arrays.asList(math, english, french));
        Student marcus = new Student(10, "Marcus", "B", Arrays.asList(russian, business, accounting));
        // group B distinct courses -> english, french, physics, math, chemistry, russian, business, accounting

        System.out.println("--------------------------------------------------------------");

        List<Student> students = Arrays.asList(ion, maria, marcel, albert, tom, john, ana, alex, diana, marcus);
        System.out.println("Exercise 5: ");
        System.out.println("Input for exercise 5: " + students + " and group A");
        System.out.println("\nOutput for exercise 5: \n");
        String output4 = exercise5(students, "A");
        System.out.println(output4);

        System.out.println("--------------------------------------------------------------");

        System.out.println("Exercise 6: ");
        System.out.println("Input for exercise 6: nothing");
        System.out.println("\nOutput for exercise 6: \n");
        System.out.println(exercise6());

        System.out.println("--------------------------------------------------------------");

        System.out.println("Exercise 7: ");
        System.out.println("Input for exercise 7: " + students);
        System.out.println("\nOutput for exercise 7: \n");
        List<Student> output5 = exercise7(students);
        System.out.println(output5);

        System.out.println("--------------------------------------------------------------");

        System.out.println("Exercise 8: ");
        System.out.println("Input for exercise 8: " + students);
        System.out.println("\nOutput for exercise 8: \n");
        List<Student> output6 = exercise8(students);
        System.out.println(output6);

        System.out.println("--------------------------------------------------------------");

        System.out.println("Exercise 9: ");
        System.out.println("Input for exercise 9: " + Arrays.asList(english, spanish, french, math, physics, chemistry, russian, business, accounting));
        System.out.println("\nOutput for exercise 9: \n");
        Map<Integer, List<Integer>> output7 = exercise9(Arrays.asList(english, spanish, french, math, physics, chemistry, russian, business, accounting));
        System.out.println(output7);

        System.out.println("--------------------------------------------------------------");

        System.out.println("Exercise 10: ");
        System.out.println("Input for exercise 10: " + students + " and group A");
        System.out.println("\nOutput for exercise 10: \n");
        List<Student> output8 = exercise10(students, "A");
        System.out.println(output8);

        System.out.println("--------------------------------------------------------------");

        System.out.println("Exercise 11: ");
        System.out.println("Input for exercise 11: " + students);
        System.out.println("\nOutput for exercise 11: \n");
        Map<String, List<Course>> output9 = exercise11(students);
        System.out.println(output9);

    }
}
