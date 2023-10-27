package member;

import java.util.ArrayList;
import java.util.List;

public class MemberPerformance {

    public static void main(String[] args) {

        // 테스트 데이터 준비
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            members.add(Member.builder()
                .id((long) i)
                .name("member" + i) //
                .age(i % 100) // 나이가 0부터 99까지 다양하게 분포하도록 조정
                .build());

        }

        // 성능 측정 시작
        long startForEach = System.nanoTime();

        // 조건에 맞는 회원 수 계산
        long countForEach = 0;
        for (Member member : members) {
            if (member.getAge() < 50) {
                countForEach++;
            }
        }

        // 성능 측정 종료
        long endForEach = System.nanoTime();

        // 밀리초 단위로 시간 계산
        long durationLoop = (endForEach - startForEach) / 1000000; // 정확한 시간 계산을 위해 순서 변경

        // 결과 출력
        System.out.println("Count ForEach: " + countForEach + ", time taken: " + durationLoop + " ms");

        System.out.println();

        // 스트림 사용 시간 측정
        long startStream = System.nanoTime();
        long countStream = members.stream().filter(m -> m.getAge() < 50).count();
        long endStream = System.nanoTime();
        long durationStream = (endStream - startStream) / 1000000; // milliseconds
        System.out.println("Stream count: " + countStream + ", time taken: " + durationStream + " ms");
    }
}
