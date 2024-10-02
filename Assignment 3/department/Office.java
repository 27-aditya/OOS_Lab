package department;

import company.Employee;
import company.Manager;

public class Office {
    public static void main(String[] args) {
        Employee emp = new Employee("ASDF");

        System.out.println("Employee name: " + emp.name); // will give error

        Manager mng = new Manager("QWER");

        mng.printName();
    }
}
