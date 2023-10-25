package member;

import java.util.List;
import member.utils.PrintUtil;

public class MemberMain {

    public static void main(String[] args) {

        MemberAssembly assembly = new MemberAssembly();
        MemberService memberService = assembly.getMemberService();

        Member requestMember = Member.builder()
            .name("member1")
            .build();

        Member member = memberService.saveMember(requestMember);

        Member findMember = memberService.findById(member.getId());

        System.out.println("findMember = " + findMember);
        PrintUtil.printLine();

        List<Member> member1 = memberService.findMembersByName("member1");
        System.out.println("member1 = " + member1);

    }

}
