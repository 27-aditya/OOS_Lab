import java.util.ArrayList;
import java.util.List;

public class Q11 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        students.add(new Student("a", 3));
        students.add(new Student("aj", 343));
        students.add(new Student("ajs", 65));
        students.add(new Student("ajsd", 23));

        List<Student> sortedStudents = students.stream()
                                         .sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
                                         .toList(); 

        for (Student student : sortedStudents) {
            System.out.println(student.name);
        }
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
}


