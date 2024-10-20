import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Now");
        List<Integer> numOfChars = words.stream()
                                        .map(String :: length)
                                        .collect(Collectors.toList());

        for(int len : numOfChars){
            System.out.println(len);
        }
    }
}
