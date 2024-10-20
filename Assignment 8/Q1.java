import java.util.ArrayList;
import java.util.List;

interface Person {
    String getPersonName();
    String getPersonID();
}

interface Student {
    List<DiningPlan> getEnrolledDiningPlans();
    void enrollDiningPlan(DiningPlan diningPlan);
    void withdrawDiningPlan(DiningPlan diningPlan);
}

interface DiningPlan {
    String getDiningPlanName();
    List<FoodItem> getFoodItems();
    double getDiningPlanPrice();
    void addFoodItem(FoodItem item);
}

class BasicDiningPlan implements DiningPlan {
    private String diningPlanName;
    private List<FoodItem> foodItems;
    private double basePrice;

    public BasicDiningPlan(String diningPlanName, double basePrice) {
        this.diningPlanName = diningPlanName;
        this.basePrice = basePrice;
        this.foodItems = new ArrayList<>();
    }

    @Override
    public String getDiningPlanName() {
        return diningPlanName;
    }

    @Override
    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    @Override
    public double getDiningPlanPrice() {
        double totalPrice = basePrice;
        for (FoodItem item : foodItems) {
            totalPrice += item.getItemPrice();
        }
        return totalPrice;
    }

    @Override
    public void addFoodItem(FoodItem item) {
        foodItems.add(item);
    }
}

class FoodItem {
    private String foodName;
    private double itemPrice;

    public FoodItem(String foodName, double itemPrice) {
        this.foodName = foodName;
        this.itemPrice = itemPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}

class StudentImpl implements Student, Person {
    private String studentName;
    private String studentID;
    private List<DiningPlan> enrolledDiningPlans;

    public StudentImpl(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.enrolledDiningPlans = new ArrayList<>();
    }

    @Override
    public String getPersonName() {
        return studentName;
    }

    @Override
    public String getPersonID() {
        return studentID;
    }

    @Override
    public List<DiningPlan> getEnrolledDiningPlans() {
        return enrolledDiningPlans;
    }

    @Override
    public void enrollDiningPlan(DiningPlan diningPlan) {
        if (!enrolledDiningPlans.contains(diningPlan)) {
            enrolledDiningPlans.add(diningPlan);
            System.out.println(studentName + " enrolled in " + diningPlan.getDiningPlanName());
        } else {
            System.out.println(studentName + " is already enrolled in " + diningPlan.getDiningPlanName());
        }
    }

    @Override
    public void withdrawDiningPlan(DiningPlan diningPlan) {
        if (enrolledDiningPlans.remove(diningPlan)) {
            System.out.println(studentName + " withdrew from " + diningPlan.getDiningPlanName());
        } else {
            System.out.println(studentName + " is not enrolled in " + diningPlan.getDiningPlanName());
        }
    }
}

class DiningManager {
    private List<DiningPlan> diningPlans;

    public DiningManager() {
        this.diningPlans = new ArrayList<>();
    }

    public void addDiningPlan(DiningPlan diningPlan) {
        diningPlans.add(diningPlan);
    }

    public void enrollStudentInDiningPlan(StudentImpl student, DiningPlan diningPlan) {
        student.enrollDiningPlan(diningPlan);
    }

    public void withdrawStudentFromDiningPlan(StudentImpl student, DiningPlan diningPlan) {
        student.withdrawDiningPlan(diningPlan);
    }

    public void printEnrollmentStatus(StudentImpl student) {
        System.out.println("Enrollment status of " + student.getPersonName() + " (ID: " + student.getPersonID() + "):");
        if (student.getEnrolledDiningPlans().isEmpty()) {
            System.out.println("No dining plans enrolled.");
        } else {
            for (DiningPlan plan : student.getEnrolledDiningPlans()) {
                System.out.println("- " + plan.getDiningPlanName() + " (Total Price: " + plan.getDiningPlanPrice() + ")");
            }
        }
    }
}

public class q1 {
    public static void main(String[] args) {
        DiningManager diningManager = new DiningManager();

        BasicDiningPlan vegDiningPlan = new BasicDiningPlan("Vegetarian Plan", 10.0);
        vegDiningPlan.addFoodItem(new FoodItem("Salad", 5.0));
        vegDiningPlan.addFoodItem(new FoodItem("Fruit", 3.0));
        diningManager.addDiningPlan(vegDiningPlan);

        StudentImpl student1 = new StudentImpl("Alice", "S001");
        diningManager.enrollStudentInDiningPlan(student1, vegDiningPlan);

        diningManager.printEnrollmentStatus(student1);
    }
}

