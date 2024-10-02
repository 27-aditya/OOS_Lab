import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<Student>students = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            int rollNo = sc.nextInt();
            String address = sc.nextLine();
            students.add(new Student(name, rollNo, address));
        }

        Student sobj = new Student("", 0, "");
        sobj.OrderByName(students);
        sobj.OrderByRollNo(students);
    }
}

interface OrderStudents{
    void OrderByRollNo(List<Student> students);
    void OrderByName(List<Student> students);
}

class Student implements OrderStudents{
    String name;
    int rollNo;
    String address;

    public Student(String name, int rollNo, String address){
        this.address = address;
        this.name = name;
        this.rollNo = rollNo;
    }

    public void OrderByName(List<Student> students){
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2){
                return s1.name.compareTo(s2.name);
            };
        });
        display(students);
    }

    public void OrderByRollNo(List<Student> students){
        Collections.sort(students, new Comparator<Student>(){
            public int compare(Student s1, Student s2){
                return Integer.compare(s1.rollNo, s2.rollNo);
            };
        });
        display(students);
    }

    public void display(List<Student> students){
        for(Student s : students){
            System.out.println("Roll No: " +  rollNo + " Name: " + name + " Address: " + address    );
        }
    }
}