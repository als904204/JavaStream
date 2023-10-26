package member;

import java.util.ArrayList;
import java.util.List;
import member.utils.PrintUtil;

public class MemberMain {

    public static void main(String[] args) {

        MemberAssembly assembly = new MemberAssembly();
        MemberService memberService = assembly.getMemberService();


        Member requestMember = Member.builder()
            .name("member1")
            .build();

        List<Member> memberList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            memberList.add(Member.builder()
                .name("member:" + i)
                .build());
        }


        Member member = memberService.saveMember(requestMember);

        Member findMember = memberService.findById(member.getId());

        System.out.println("findMember = " + findMember);
        PrintUtil.printLine();

        List<Member> member1 = memberService.findMembersByName("member1");
        System.out.println("member1 = " + member1);
        PrintUtil.printLine();

        List<Member> containingMember = memberService.findMembersByContainingName("member");

        System.out.println("containingMember = " + containingMember);
        PrintUtil.printLine();


        memberService.saveAllMembers(memberList);
        PrintUtil.printLine();

        int memberDataBaseSize = memberService.getMemberDataBaseSize();
        System.out.println("memberDataBaseSize = " + memberDataBaseSize);
        PrintUtil.printLine();

        memberService.deleteMember(101L);

    }

}
