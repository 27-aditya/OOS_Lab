import java.util.Scanner;
public class Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int num1, num2;

        do {
            System.out.println("Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextInt();
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case 2:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextInt();
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case 3:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextInt();
                    System.out.println("Result: " + (num1 * num2));
                    break;
                case 4:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextInt();
                    if (num2 != 0) {
                        System.out.println("Result: " + (num1 / num2));
                    } else {
                        System.out.println("Division by zero is not allowed.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 5);

        scanner.close();
    }   
}
