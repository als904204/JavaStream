package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream01 {

    public static void main(String[] args) {
        // 배열 스트컬
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::print);
        System.out.println();

        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        streamOfArrayPart.forEach(System.out::print);
        System.out.println();

        // 컬렉션 생성
        List<String> list = Arrays.asList("a", "b", "c");

        // 컬렉션 스트림
        Stream<String> collectionStream = list.stream();
        collectionStream.forEach(System.out::print);
        System.out.println();


        // 병렬처리 스트림
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(System.out::print);
        System.out.println();

        // 스트림 빌더로 생성
        Stream<String> buildStream = Stream.<String>builder()
            .add("손흥민")
            .add("김민재")
            .add("SIUUU")
            .build();
        buildStream.forEach(System.out::print);
        System.out.println();



    }
}
