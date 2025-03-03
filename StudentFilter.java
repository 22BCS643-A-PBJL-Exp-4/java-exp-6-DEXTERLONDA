import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Deepak Yadav", 85),
            new Student("Dev Karan", 72),
            new Student("Aditya", 90),
            new Student("Rishit", 65),
            new Student("Abhijeet", 78)
        );

        List<String> topStudents = students.stream()
            .filter(s -> s.marks > 75)
            .sorted(Comparator.comparingDouble(s -> s.marks))
            .map(s -> s.name)
            .collect(Collectors.toList());

        System.out.println("Students scoring above 75%, sorted by marks: " + topStudents);
    }
}


// output:
// Students scoring above 75%, sorted by marks: [Abhijeet, Deepak Yadav, Aditya]
