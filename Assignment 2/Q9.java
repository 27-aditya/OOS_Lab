import java.util.*;

class Student {
    int rollNumber;
    String fullName;
    int height;
    int weight;
    int teacherId;

    public Student(int rollNumber, String fullName, int height, int weight, int teacherId) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.height = height;
        this.weight = weight;
        this.teacherId = teacherId;
    }

    public void addStudent() {
        System.out.println(fullName + " has been added to the student list.");
    }

    static void sortByHeight(ArrayList<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.height, s2.height);
            }
        });
    }

    static void printStudentList(ArrayList<Student> studentList, String[] teacherNames) {
        for (Student student : studentList) {
            System.out.println("Roll Number: " + student.rollNumber);
            System.out.println("Full Name: " + student.fullName);
            System.out.println("Height: " + (float)student.height);
            System.out.println("Weight: " + (float)student.weight);
            System.out.println("Assigned Teacher: " + teacherNames[student.teacherId - 1]);
        }
        System.out.println();
    }
}

class Teacher {
    int teacherId;
    String studentName;

    public Teacher(int teacherId, String studentName) {
        this.teacherId = teacherId;
        this.studentName = studentName;
    }

    static void printTeacherAssignments(ArrayList<Teacher> teacherList, String[] teacherNames) {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.studentName + " - " + teacherNames[teacher.teacherId - 1]);
        }
    }
}

public class Q9 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] teacherNames = {"Mr. Sabu", "Ms. Jaya", "Dr. Babu"};

        System.out.print("Enter the number of students to add: ");
        int numberOfStudents = scanner.nextInt();
        ArrayList<Student> studentList = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter roll number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();
            System.out.print("Enter height: ");
            int height = scanner.nextInt();
            System.out.print("Enter weight: ");
            int weight = scanner.nextInt();
            System.out.println("Available teachers:\r\n" + //
                               "1. Mr. Sabu\r\n" + //
                               "2. Ms. Jaya\r\n" + //
                               "3. Dr. Babu");
            System.out.print("Choose a teacher by ID: ");
            int teacherId = scanner.nextInt();
            studentList.add(new Student(rollNumber, fullName, height, weight, teacherId));
            studentList.get(i).addStudent();
        }

        Student.sortByHeight(studentList);

        ArrayList<Teacher> teacherAssignments = new ArrayList<>();
        for (Student student : studentList) {
            teacherAssignments.add(new Teacher(student.teacherId, student.fullName));
        }

        System.out.println("All students sorted by height:");
        Student.printStudentList(studentList, teacherNames);

        System.out.println("Student Names and their Assigned Teachers:");
        Teacher.printTeacherAssignments(teacherAssignments, teacherNames);
        
        scanner.close();
    }
}
