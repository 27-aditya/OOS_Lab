import java.util.Arrays;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Aero", "Bomb", "Ate");
        words.stream()
             .filter(word -> word.charAt(0) == 'A')
             .forEach(System.out :: println);
    }
}
