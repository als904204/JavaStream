package streamAPI;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stream01 {

    public static void main(String[] args) {
        // 배열 스트림
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
    }
}
