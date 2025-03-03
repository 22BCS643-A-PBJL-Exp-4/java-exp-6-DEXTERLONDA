import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + age + ", " + salary + ")";
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Deepak Yadav", 20, 50000),
            new Employee("Nitesh kumar", 22, 60000),
            new Employee("Dev karan", 21, 55000)
        ));

        // Sorting by name
        employees.sort(Comparator.comparing(e -> e.name));
        System.out.println("Sorted by name: " + employees);

        // Sorting by age
        employees.sort(Comparator.comparingInt(e -> e.age));
        System.out.println("Sorted by age: " + employees);

        // Sorting by salary
        employees.sort(Comparator.comparingDouble(e -> e.salary));
        System.out.println("Sorted by salary: " + employees);
    }
}

