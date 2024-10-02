import java.util.ArrayList;
import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();
        boolean running = true;

        while (running) {
            System.out.println("\nUniversity Management System");
            System.out.println("1. Add Department");
            System.out.println("2. Add Professor");
            System.out.println("3. Add Student");
            System.out.println("4. List Departments");
            System.out.println("5. List Professors in a Department");
            System.out.println("6. List Students in a Department");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Department
                    System.out.print("Enter department name: ");
                    String deptName = scanner.nextLine();
                    university.addDepartment(deptName);
                    System.out.println("Department added.");
                    break;

                case 2:
                    // Add Professor
                    System.out.print("Enter department index (0-based): ");
                    int deptIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter professor name: ");
                    String profName = scanner.nextLine();
                    System.out.print("Enter professor ID: ");
                    int profId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter professor department: ");
                    String profDept = scanner.nextLine();
                    university.addProfessor(deptIndex, profName, profId, profDept);
                    System.out.println("Professor added.");
                    break;

                case 3:
                    // Add Student
                    System.out.print("Enter department index (0-based): ");
                    int deptIndexStudent = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student major: ");
                    String studentMajor = scanner.nextLine();
                    university.addStudent(deptIndexStudent, studentName, studentId, studentMajor);
                    System.out.println("Student added.");
                    break;

                case 4:
                    // List Departments
                    university.listDepartments();
                    break;

                case 5:
                    // List Professors in a Department
                    System.out.print("Enter department index (0-based): ");
                    int deptIndexProf = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    university.listProfessors(deptIndexProf);
                    break;

                case 6:
                    // List Students in a Department
                    System.out.print("Enter department index (0-based): ");
                    int deptIndexStudentList = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    university.listStudents(deptIndexStudentList);
                    break;

                case 7:
                    // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Student extends Person {
    String major;

    public Student(String name, int id, String major) {
        super(name, id);
        this.major = major;
    }

    public String toString() {
        return "Student{name='" + name + "', id=" + id + ", major='" + major + "'}";
    }
}

class Professor extends Person {
    String department;

    public Professor(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    public String toString() {
        return "Professor{name='" + name + "', id=" + id + ", department='" + department + "'}";
    }
}

class Department {
    ArrayList<Student> students;
    ArrayList<Professor> professors;
    String name;

    public Department(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }
}

class University {
    ArrayList<Department> departments;

    public University() {
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String name) {
        departments.add(new Department(name));
    }

    public void addProfessor(int departmentIndex, String name, int id, String department) {
        if (departmentIndex < 0 || departmentIndex >= departments.size()) {
            System.out.println("Invalid department index.");
            return;
        }
        Professor professor = new Professor(name, id, department);
        departments.get(departmentIndex).addProfessor(professor);
    }

    public void addStudent(int departmentIndex, String name, int id, String major) {
        if (departmentIndex < 0 || departmentIndex >= departments.size()) {
            System.out.println("Invalid department index.");
            return;
        }
        Student student = new Student(name, id, major);
        departments.get(departmentIndex).addStudent(student);
    }

    public void listDepartments() {
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(i + ": " + departments.get(i).getName());
        }
    }

    public void listProfessors(int departmentIndex) {
        if (departmentIndex < 0 || departmentIndex >= departments.size()) {
            System.out.println("Invalid department index.");
            return;
        }
        Department dept = departments.get(departmentIndex);
        if (dept.getProfessors().isEmpty()) {
            System.out.println("No professors in this department.");
            return;
        }
        for (Professor prof : dept.getProfessors()) {
            System.out.println(prof);
        }
    }

    public void listStudents(int departmentIndex) {
        if (departmentIndex < 0 || departmentIndex >= departments.size()) {
            System.out.println("Invalid department index.");
            return;
        }
        Department dept = departments.get(departmentIndex);
        if (dept.getStudents().isEmpty()) {
            System.out.println("No students in this department.");
            return;
        }
        for (Student student : dept.getStudents()) {
            System.out.println(student);
        }
    }
}