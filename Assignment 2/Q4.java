import java.util.Scanner;
class Solution{
    // Recursive max function 
    int max;
    public int arrMax(int[] arr, int n, int index){
        if(index >= n) 
            return max;
        max = Math.max(max, arr[index]);
        return arrMax(arr, n, index+1);
    }

}
class Q4{
    // Question Class
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        sc.nextLine();

        Solution S = new Solution();

        // Take the input.
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.println("Enter the " + i + "th element");
            arr[i] = sc.nextInt();
        }

        // Call the function.
        int maxEle = S.arrMax(arr, n, 0);
        System.out.println("The max element is: ");
        System.out.println(maxEle);
        sc.close();
    }
}