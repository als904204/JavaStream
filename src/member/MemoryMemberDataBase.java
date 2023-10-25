package member;

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
        member.setId(memberId); // Member 객체에 ID 설정
        memberStore.put(memberId, member);
        return member; // 저장된 회원 반환
    }

    public Optional<Member> findMemberById(Long id) {
        System.out.println("DB : ID 로 회원 찾기");
        return Optional.ofNullable(memberStore.get(id));
    }


}
