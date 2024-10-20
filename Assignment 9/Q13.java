import java.util.Arrays;
import java.util.List;

public class Q13 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5);

        int mul = numbers.stream()
                         .reduce(1, (num1, num2) -> num1 * num2); 

        System.out.println(mul);
    }
}
