import java.util.Scanner;
public class Q9 {
    public static int[] findCnt(String str) {
		int[] arr = new int[26];
		int n = str.length();

		for(int i = 0; i < n; i++){
			arr[str.charAt(i) - 'a']++;
		}

		return arr;
	}
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        int[] arr = findCnt(str);

        for(int i = 0; i < str.length(); i++){
            System.out.println("Freq of " + str.charAt(i) + " is " + arr[str.charAt(i) - 'a']);
        }
        sc.close();
    }
}
