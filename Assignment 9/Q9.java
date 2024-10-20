import java.util.Arrays;
import java.util.List;

public class Q9{
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("3" , "5", "7");
        int total = numbers.stream()
                           .mapToInt(num -> Integer.parseInt(num))
                           .sum();
        System.out.println(total);
    }
}