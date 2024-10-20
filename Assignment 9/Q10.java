import java.util.Arrays;

public class Q10 {
    public static void main(String[] args) {
        Student[] students = new Student[10];

        for(int i = 0; i < 10; i++){
            students[i] = new Student("i", i);
        }

        double avgAge = Arrays.stream(students)
                              .mapToInt(Student :: getAge)
                              .average().orElse(0.0);
        System.out.println(avgAge);
        
    }
    
}

class Student{
    public String name;
    public int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}