import java.util.Scanner;
public class Q6 {
    public static void fib(int n){
		if(n == 0) 
            return;
		else if(n == 1){
			System.out.println(0);
			return;
		}
		else{
			System.out.println(0);
			System.out.println(1);
		}
		int pre1 = 0;

		int pre2 = 1;

		for(int i = 3 ; i <= n; i++){
			int temp = pre1 + pre2;
			System.out.println(temp);
			pre1 = pre2;
			pre2 = temp;
		}
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of terms");
        int n = sc.nextInt();
        fib(n);
        sc.close();
    }
    
}
