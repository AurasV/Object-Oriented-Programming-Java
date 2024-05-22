import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Contract implements Storable {
    private ArrayList<Course> courses;

    public Contract(){
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void deleteCourse(Course.Type type, Course.Stream stream, String name){
        for (Course course : courses) {
            if (course.getName().equals(name) && course.getType().equals(type) && course.getStream().equals(stream)) {
                courses.remove(course);
                break;
            }
        }
    }

    public void sort() {
        Collections.sort(courses, new Comparator<Course>() {
            @Override
            public int compare(Course course1, Course course2) {
                int streamComparison = course1.getStream().compareTo(course2.getStream());
                if (streamComparison != 0) {
                    return streamComparison;
                }

                int typeComparison = course1.getType().compareTo(course2.getType());
                if (typeComparison != 0) {
                    return typeComparison;
                }

                int nameComparison = course1.getName().compareTo(course2.getName());
                if (nameComparison != 0) {
                    return nameComparison;
                }
                else {
                    try {
                        throw new CustomCourseComparisonException("Two cards are equal.");
                    } catch (CustomCourseComparisonException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    @Override
    public void store(String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Course course : courses) {
                writer.write(course.getStream() + " " + course.getType() + " " + course.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display(){
        for (Course course : courses) {
            System.out.println(course.getStream() + " " + course.getType() + " " + course.getName() + " points - " + course.getCreditPoints());
        }
    }
}
