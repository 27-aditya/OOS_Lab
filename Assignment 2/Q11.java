import java.util.HashSet;
import java.util.Scanner;

// Class employee manager
class EmployeeManager {
    private HashSet<Integer> employeeIds; // Set to store unique employee IDs

    // Constructor
    public EmployeeManager() {
        employeeIds = new HashSet<>();
    }

    // Method to add 
    public boolean addEmployeeId(int id) {
        if (employeeIds.add(id)) {
            return true; 
        } else {
            return false; 
        }
    }

    // Method to remove an employee ID
    public boolean removeEmployeeId(int id) {
        if (employeeIds.remove(id)) {
            return true; 
        } else {
            return false; 
        }
    }

    // Method to display all employee IDs
    public void displayEmployeeIds() {
        if (employeeIds.isEmpty()) {
        } else {
            for (int id : employeeIds) {
                System.out.println(id);
            }
        }
    }
}

// Main class 
public class Q11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        while (true) {
            // Menu
            System.out.println("\nSelect the operation:");

            // User's choice
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add an employee
                    System.out.println("Enter the ID:");
                    int addId = scanner.nextInt();
                    manager.addEmployeeId(addId);
                    break;
                case 2:
                    // Remove an employee
                    System.out.println("Enter the ID:");
                    int removeId = scanner.nextInt();
                    manager.removeEmployeeId(removeId);
                    break;
                case 3:
                    // Display all employees
                    manager.displayEmployeeIds();
                    break;
                case 4:
                    // Exit the program
                    scanner.close(); // Close the scanner
                    return;
            }
        }
    }
}
