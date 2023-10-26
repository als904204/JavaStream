package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryMemberDataBase {


    private final Map<Long, Member> memberStore = new ConcurrentHashMap<>();

    private static volatile MemoryMemberDataBase instance;


    private final AtomicLong sequenceId = new AtomicLong(0);

    private MemoryMemberDataBase() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() Method get the Single instance");
        }
    }

    public static MemoryMemberDataBase getInstance() {
        if (instance == null) {
            synchronized (MemoryMemberDataBase.class) {
                if (instance == null) {
                    instance = new MemoryMemberDataBase();
                }
            }
        }
        return instance;
    }

    public int getMemberStoreSize() {
        System.out.println("DB : 회원 DB 사이즈 요청");
        return memberStore.size();
    }

    public Member saveMember(Member member) {
        System.out.println("DB : 회원 저장 중...");
        Long memberId = sequenceId.incrementAndGet();
        member.setId(memberId);
        memberStore.put(memberId, member);
        return member;
    }

    public void deleteMember(Long id) {
        System.out.println("DB : ID 로 회원 삭제 실행");
        findMemberById(id).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회원 입니다"));
        memberStore.remove(id);
        System.out.println(id+" 회원 삭제 성공");

    }

    public List<Member> saveAllMembers(List<Member> members) {
        System.out.println("DB : 여러 회원 저장 중...");
        for (Member member : members) {
            Long memberId = sequenceId.incrementAndGet();
            member.setId(memberId);
            memberStore.put(memberId, member);
        }
        return members;
    }

    public Optional<Member> findMemberById(Long id) {
        System.out.println("DB : ID 로 회원 찾기");
        return Optional.ofNullable(memberStore.get(id));
    }

    public List<Member> findAllMembers() {
        System.out.println("DB : 모든 회원 조회");
        return new ArrayList<>(memberStore.values());
    }


    // 스트림을 사용한 회원 조회
    public List<Member> findMembersByName(String name) {
        System.out.println("DB : ("+name+") 모든 이름 조회");
        return memberStore.values().stream()
            .filter(m -> m.getName().equals(name))
            .toList();
    }

    // name 을 포함한 회원 Stream 조회
    public List<Member> findMembersByContainingName
        (String name) {
        return memberStore.values().stream()
            .filter(m -> m.getName().contains(name))
            .toList();
    }

    // 해당 이름을 가진 회원 수 조회
    public long countMembersWithSpecificName(String name) {
        return memberStore.values().stream()
            .filter(m -> m.getName().equals(name))
            .count();
    }

    // 스트림을 사용하지 않고 해당 이름을 가진 회원 수 조회
    public long countMembersWithSpecificNameNonStream(String name) {
        long count = 0;
        for (Member member : memberStore.values()) {
            if (member.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }




}
