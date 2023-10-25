package member;

/**
 * MemberDB.class
 * MemberService.class
 * 의존 주입 클래스
 */
public class MemberAssembly {


    private final MemoryMemberDataBase memberDataBase;
    private final MemberService memberService;

    public MemberAssembly() {
        this.memberDataBase = MemoryMemberDataBase.getInstance();
        this.memberService = new MemberService(memberDataBase);
    }

    public MemberService getMemberService() {
        return this.memberService;
    }

}
