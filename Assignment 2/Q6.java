import java.util.Scanner;

public class Q6 {
    // Main class
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
        System.out.println("Are you guest: ");
        String guest = sc.nextLine();
        System.out.println("Are you vegetarian: ");
        String veg = sc.nextLine();
        System.out.println("Enter the number of days: ");
        int days = sc.nextInt();
        Solution S = new Solution();
        System.out.println("Total bill for " + name + " is: " + S.totalBill(guest, veg, days));
        sc.close();
    }
}

class Solution{
    public float totalBill(String guest, String veg, int days){
        float total = 0;
        if(veg.equals("yes")){
            total = days*100; // cost for veg
        }
        else{
            total = days*120; // cost for non veg
        }
        if(guest.equals("yes")){ // if the customer is guest pays extra
            total += 0.1F*(total);
        }
        return total;
    }
}
