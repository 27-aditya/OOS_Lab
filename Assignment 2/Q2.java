import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string:");
        String input = sc.nextLine();
        
        System.out.println("Enter the target string:");
        String target = sc.nextLine();
        
        System.out.println("Enter the replacement:");
        String replacement = sc.nextLine();
        
        String result = input.replaceAll(target, replacement); // replaceAll function to replace the substring 
        
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result);
        sc.close();
    }
}
