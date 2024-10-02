import java.util.Scanner;
public class Q2 {
    public static int binarySearch(int[] arr, int key){
		int n = arr.length;

		int left = 0;
		int right = n-1;

		while(left < right){
			int mid = left + (right - left)/2;

			if(arr[mid] == key)
				return mid;
			else if(arr[mid] < key){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
		}

		return -1;
	}

    public static void main(String[] args) {
        System.out.println("Enter the size of the array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int idx = 0; idx < size; idx++){
            System.out.println("Enter the element at index " + idx);
            arr[idx] = sc.nextInt();
        }

        System.out.println("Enter the key to search");
        int key = sc.nextInt();
        System.out.println(binarySearch(arr, key));
        sc.close();
    }
}
