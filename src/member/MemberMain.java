package member;

import static member.utils.PrintUtil.printLine;

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
                .age(i)
                .build());
        }


        Member member = memberService.saveMember(requestMember);

        Member findMember = memberService.findById(member.getId());

        System.out.println("findMember = " + findMember);
        printLine();

        List<Member> member1 = memberService.findMembersByName("member1");
        System.out.println("member1 = " + member1);
        printLine();

        List<Member> containingMember = memberService.findMembersByContainingName("member");

        System.out.println("containingMember = " + containingMember);
        printLine();


        memberService.saveAllMembers(memberList);
        printLine();

        int memberDataBaseSize = memberService.getMemberDataBaseSize();
        System.out.println("memberDataBaseSize = " + memberDataBaseSize);
        printLine();

        memberService.deleteMember(101L);
        printLine();

        long countMemberByNameStream = memberService.countMemberByName("member1");
        System.out.println("countMemberByNameStream = " + countMemberByNameStream);
        long countMemberByNameNonStream = memberService.countMemberByNameNonStream("member1");
        System.out.println("countMemberByName = " + countMemberByNameNonStream);
        printLine();

        List<Member> allMembers = memberService.findAllMembers();
        System.out.println("allMembers = " + allMembers);
        printLine();


    }

}
