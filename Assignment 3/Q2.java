import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String initialPosition = sc.nextLine();
        int initialRow = Integer.parseInt(initialPosition.substring(0, 1));
        int intialColumn = Integer.parseInt(initialPosition.substring(1, 2));

        int n = sc.nextInt();
        sc.nextLine();

        String[] movements = sc.nextLine().split(" ");

        int currRow = initialRow;
        int currCol = intialColumn;

        for(int i = 0; i < n*2; i+=2){
            String direction = movements[i];
            int moves = Integer.parseInt(movements[i+1]);

            switch (direction) {
                case "Up":
                    currRow -= moves;
                    break;
                case "Down":
                    currRow += moves;
                    break;
                case "Left":
                    currCol -= moves;
                    break;
                case "Right":
                    currCol += moves;
                    break;
                default:
                    break;
            }

            if(currCol < 1 || currCol > 8 || currRow < 1 || currRow > 8){
                System.out.println("Overflow");
                return;
            }
        }
        System.out.println("[" + currRow + "," + currCol + "]");
        sc.close();
    }
}
