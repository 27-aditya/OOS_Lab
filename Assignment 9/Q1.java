import java.util.Arrays;
import java.util.List;

public class Q1{
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Now");
        words.stream().forEach(word -> System.out.println(word));   
    }
}