import java.util.Scanner;
public class Q1 {
    public static int factorial(int n){
		if(n == 0 || n == 1) return 1;

		return n*factorial(n-1);
	}

    public static void main(String []args)
    {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(factorial(num));
        sc.close();
    }
}
