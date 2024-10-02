import java.util.Scanner;
public class Q10 {
    public static void swapString(String a, String b){
		int la = a.length();
		System.out.println("Before Swapping, a: " + a + " b: " +b);
		a = a+b;
		b = a.substring(0, la);
		int af = a.length();
		a = a.substring(la, af);
		System.out.println("After Swapping: a: " + a + " b: " + b);
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st string");
        String a = sc.nextLine();
        System.out.println("Enter 2nd string");
        String b = sc.nextLine();
        swapString(a, b);
        sc.close();
    }
}
