import java.util.Scanner;
public class Q5 {
    public static void revString(String str){
		StringBuffer sbf = new StringBuffer(str);
		System.out.println("Before reversing: " + str);
		sbf.reverse();
		System.out.println("After reversing: " + sbf);
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        revString(str);
        sc.close();
    }
}
