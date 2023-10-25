package member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberDataBase {


    private final Map<Long, Member> memberStore = new ConcurrentHashMap<>();

    private static volatile MemoryMemberDataBase instance;

    private Long sequenceId;

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
        System.out.println("회원 DB 사이즈 요청");
        return memberStore.size();
    }


}
