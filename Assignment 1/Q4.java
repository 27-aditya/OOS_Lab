import java.util.Scanner;
public class Q4 {
    public static boolean hasVowels(String str){
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
				return true;
		}	
		return false;
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        System.out.println(hasVowels(str));
        sc.close();
    }
}
