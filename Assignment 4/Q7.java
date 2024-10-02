public class Q7 {
    public static void main(String[] args) {
        Manager m1 = new Manager("John", 100.00, "Cloud");
        Developer d1 = new Developer("Aditya", 10000.0, "C++");

        m1.displayDetails();
        d1.displayDetails();
    }
}

class Employee{
    String name;
    double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee{
    String departmentName;

    public Manager(String name, double salary, String departmentName){
        super(name, salary);
        this.departmentName = departmentName;
    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Department: " + departmentName);
    }
}

class Developer extends Employee{
    String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage){
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}