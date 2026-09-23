package oop_test.ch04;

import java.util.List;

public class MemberService {

    private MemberDao dao = new MemberDao();

    public void registerMember(String id, String name) {
        Member member = new Member(id, name);
        dao.insert(member);
    }

    public void printAllMembers() {
        List<Member> members = dao.fineAll();
        System.out.println("--- 전체 회원 목록 ---");
        for (Member member : members) {
            System.out.println("ID: " + member.getId() + "이름: " + member.getName());
        }
    }
}
