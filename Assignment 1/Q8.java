import java.util.Scanner;
public class Q8 {
    public static int[][] transpose(int[][] A, int rows, int cols){
		int[][] B = new int[cols][rows];

		for(int i = 0; i < cols; i++){
			for(int j = 0; j < rows; j++){
				B[j][i] = A[i][j];
			}
		}

		return B;
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns");
        int cols = sc.nextInt();

        int[][] A = new int[rows][cols];    
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.println("Enter the element at index (" + i + ", " + j + ")");
                A[i][j] = sc.nextInt();
            }
        }

        int[][] B = transpose(A, rows, cols);

        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                System.out.println(B[i][j]);
            }
        }
        sc.close();
    }
}
