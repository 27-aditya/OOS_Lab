public class Q8{

}

class Employee{
    public String name;
    public int age;
    public String address;
    public String phone;
    double salary;

    public Employee(String name, int age, String address, String phone, double salary) {
        this.address = address;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.salary = salary;
    }

    public void getDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }

    public void updateDetails(String name, int age, String address, String phone){
        this.address = address;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public int calculateAnnualSalary(){
        System.out.println("Annual Salary: " + 12*salary);
        return (int) (12*salary);
    }
}

class Officer extends Employee{
    String specialization;

    public Officer(String name, int age, String address, String phone, double salary, String specialization){
        super(name, age, address, phone, salary);
        this.specialization = specialization;
    }

    public String getSpecialization(){
        System.out.println("Specialization: " + specialization);
        return specialization;
    }

    public void updateSpecialization(String specialization){
        this.specialization = specialization;
    }
    
    public int calculateSalary(){
        int normalSalary = calculateAnnualSalary();
        normalSalary += 0.1*normalSalary;
        return normalSalary;
    }
}

class Manager extends Employee{
    String department;

    public Manager(String name, int age, String address, String phone, double salary, String department){
        super(name, age, address, phone, salary);
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }

    public void updateDepartment(String newDepartment){
        this.department = newDepartment;
    }
    
    public int calculateSalary(){
        int normalSalary = calculateAnnualSalary();
        normalSalary += 0.1*normalSalary;
        return normalSalary;
    }
}