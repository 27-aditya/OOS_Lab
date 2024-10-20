import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q8 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Aero", "Bomb", "Ate");
        Predicate<String>capA = word -> word.charAt(0) == 'A';
        List<String>capAs = words.stream()
                                 .filter(capA)
                                 .collect(Collectors.toList());
        capAs.stream().forEach(System.out :: println);
    }
}
