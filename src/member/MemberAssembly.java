package member;

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
