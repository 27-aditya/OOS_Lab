import java.util.Scanner;

public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String operator = sc.nextLine();
        int op1 = sc.nextInt();
        int op2 = sc.nextInt();
        switch (operator) {
            case "+":
                System.out.println(op1+op2);
                break;
            case "-":
                System.out.println(op1-op2);
                break;
            case "*":
                System.out.println(op1*op2);
                break;
            case "/":
                if(op2 == 0)
                    System.out.println("Arithmetic Exception: Division by zero handled. Enter a valid argument.");
                else
                    System.out.println(op1/op2);
                break;
            default:
                System.out.println("Enter a valid operator");
                break;
        }
        sc.close();
    }
}
