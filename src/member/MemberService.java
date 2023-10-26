package member;

import java.util.List;

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

    public List<Member> findMembersByName(String name) {
        return memberDataBase.findMembersByName(name);
    }

    public List<Member> findMembersByContainingName(String name) {
        return memberDataBase.findMembersByContainingName(name);
    }

    public List<Member> saveAllMembers(List<Member> members) {
        return memberDataBase.saveAllMembers(members);
    }

    public void deleteMember(Long id) {
        memberDataBase.deleteMember(id);
    }

    public long countMemberByName(String name) {
        return memberDataBase.countMembersWithSpecificName(name);
    }

    public long countMemberByNameNonStream(String name) {
        return memberDataBase.countMembersWithSpecificNameNonStream(name);
    }
}
