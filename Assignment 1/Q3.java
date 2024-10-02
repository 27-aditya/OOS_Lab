import java.util.*;
public class Q3 {
    static class Student{
        String name;
        int roll;
    
        Student(String name, int roll){
            this.name = name;
            this.roll = roll;
        }
    
        public String toString(){
            return "Name: " + name + " Roll: " + roll;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students");
        int n = sc.nextInt();
        sc.nextLine();
        Student[] students = new Student[n];

        for(int i = 0; i < n; i++){
            System.out.println("Enter the name of student " + (i+1));
            String name = sc.nextLine();
            System.out.println("<----->");
            System.out.println("Enter the roll of student " + (i+1));
            int roll = sc.nextInt();
            sc.nextLine();

            students[i] = new Student(name, roll);
        }

        Arrays.sort(students, Comparator.comparingInt(s -> s.roll));

        System.out.println("Sorted students are:");

        for(int i = 0; i < n; i++){
            System.out.println(students[i]);
        }
        sc.close();
    }
}
