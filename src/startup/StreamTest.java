package startup;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args)
    {
        String[] str = {"abc", "def", "dsfds","dfa"};
        Stream<String> stringStream = Arrays.stream(str);
        Optional<String> max = stringStream.max(String::compareToIgnoreCase);
        System.out.println(max.get());
    }
}
