abstract class Employee {
    protected int id;
    protected String name;
    protected int leaveDays;

    public Employee(int id, String name, int leaveDays) {
        this.id = id;
        this.name = name;
        this.leaveDays = leaveDays;
    }

    public abstract double calculateSalary();

    public double calculateLeaveDeduction(int leaveDays, double dailyRate) {
        return leaveDays * dailyRate;
    }
}

class FullTimeEmployee extends Employee {
    private String position;
    private double baseSalary;

    public FullTimeEmployee(String name, int id, String position, double baseSalary, int leaveDays) {
        super(id, name, leaveDays);
        this.position = position;
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        double dailyRate = baseSalary / 30;
        double deduction = calculateLeaveDeduction(leaveDays, dailyRate);
        return baseSalary - deduction;
    }

    public double calculateSalary(String position) {
        double salary = calculateSalary();
        if (position.equalsIgnoreCase("Manager")) {
            return salary * 1.1;
        }
        return salary;
    }

    public double calculatePerformanceBonus(double performanceScore) {
        if (performanceScore > 90) {
            return baseSalary * 0.04;
        }
        return 0;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyWage;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyWage, int leaveDays) {
        super(id, name, leaveDays);
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double calculateSalary() {
        double dailyRate = hourlyWage * 8;
        double deduction = calculateLeaveDeduction(leaveDays, dailyRate);
        return (hoursWorked * hourlyWage) - deduction;
    }

    public double calculateSalary(int hoursWorked, boolean bonusEligible) {
        double salary = calculateSalary();
        if (bonusEligible && hoursWorked > 40) {
            salary += 100;
        }
        return salary;
    }

    public double calculatePerformanceBonus(double performanceScore) {
        if (performanceScore > 85) {
            return hoursWorked * hourlyWage * 0.2;
        }
        return 0;
    }
}

public class Q3 {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Alice", 101, "Manager", 50000, 2);
        System.out.println("Full-Time Salary (Manager, after leave deduction): " +
                fullTimeEmployee.calculateSalary("Manager"));
        System.out.println("Full-Time Performance Bonus: " +
                fullTimeEmployee.calculatePerformanceBonus(92));

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Bob", 102, 45, 20, 1);
        System.out.println("Part-Time Salary (with bonus, after leave deduction): " +
                partTimeEmployee.calculateSalary(45, true));
        System.out.println("Part-Time Performance Bonus: " +
                partTimeEmployee.calculatePerformanceBonus(87));
    }
}
