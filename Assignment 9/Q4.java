import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q4 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Now");
        List<String> capWords = words.stream()
                                     .map(String :: toUpperCase)
                                     .collect(Collectors.toList());

        for(String word : capWords){
            System.out.println(word);
        }
    }
}
