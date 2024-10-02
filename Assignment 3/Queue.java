import java.util.ArrayList;
import java.util.Scanner;

//Q3.java

public class Queue {
    static ArrayList<Integer> queue = new ArrayList<>();

    // Make the methods static
    public static void enqueue(Integer num) {
        queue.add(num);
        System.out.println("Success");
    }

    public static void dequeue() {
        if (queue.size() == 0) {
            System.out.println("EmptyQueue");
        } else {
            System.out.println(queue.get(0));
            queue.remove(0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            String[] ip = input.split(" ");

            if (ip[0].equals("E")) {
                int num = Integer.parseInt(ip[1]);
                enqueue(num);  
            } else {
                dequeue();  
            }
            
        }
    }
}
