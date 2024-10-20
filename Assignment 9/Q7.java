import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Aero", "Bomb", "Ate");
        List<String>capA = words.stream()
                                .filter(word -> word.charAt(0) == 'A')
                                .collect(Collectors.toList());
        capA.stream().forEach(System.out :: println);
    }    
}
