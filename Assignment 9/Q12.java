import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q12 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        students.add(new Student("a", 3));
        students.add(new Student("aj", 343));
        students.add(new Student("ajs", 65));
        students.add(new Student("ajsd", 23));

        Map<Integer, List<String>> groupedByAge = students.stream()
                                                          .collect(Collectors.groupingBy(
                                                              Student::getAge,                      
                                                              Collectors.mapping(Student::getName, Collectors.toList()) 
                                                          ));

        groupedByAge.forEach((age, names) -> {
            System.out.println(age + " " + names);
        });
    }
}


class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

