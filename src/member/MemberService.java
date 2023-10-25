package member;

public class MemberService {

    private final MemoryMemberDataBase memberDataBase;

    public MemberService(MemoryMemberDataBase memberDataBase) {
        this.memberDataBase = memberDataBase;
    }

    public Member saveMember(Member member) {
        return memberDataBase.saveMember(member);
    }
    public int getMemberDataBaseSize() {
        return memberDataBase.getMemberStoreSize();
    }

    public Member findById(Long id) {
        return memberDataBase.findMemberById(id).orElseThrow(()-> new IllegalArgumentException("회원을 찾을 수 없습니다"));
    }



}
