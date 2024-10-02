public class Q3 {
    public static void main(String[] args) {
        Employee employee = new Employee("Alice Brown", 50000, 35);
        Analyst analyst = new Analyst("John Doe", 80000, 30, "Data Analysis");
        Salesperson salesperson = new Salesperson("Jane Smith", 60000, 28, "North America");

        employee.getDetails();
        analyst.getDetails();
        salesperson.getDetails();

        employee.raiseSalary(5000);
        analyst.raiseSalary(7000);
        salesperson.raiseSalary(4000);

        employee.getDetails();
        analyst.getDetails();
        salesperson.getDetails();

        System.out.println("\nTotal Number of Employees: " + Employee.getEmployeeCount());
    }
}

class Employee {
    String name;
    double salary;
    int age;
    static int employeeCount = 0;

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        incrementCount();
    }

    public void getDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salary);
    }

    public void raiseSalary(double amount) {
        this.salary += amount;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void incrementCount() {
        employeeCount++;
    }
}

class Analyst extends Employee {
    String specialization;

    public Analyst(String name, double salary, int age, String specialization) {
        super(name, salary, age);
        this.specialization = specialization;
    }

    public void getDetails() {
        super.getDetails();
        System.out.println("Specialization" + specialization);
    }
}

class Salesperson extends Employee {
    String region;

    public Salesperson(String name, double salary, int age, String region) {
        super(name, salary, age);
        this.region = region;
    }

    public void getDetails() {
        super.getDetails();
        System.out.println("Region: " + region);
    }
}