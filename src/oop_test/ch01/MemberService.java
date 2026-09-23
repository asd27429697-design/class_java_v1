package oop_test.ch01;

public class MemberService {

    private MemberDao dao = new MemberDao();

    public void registerMember(String id, String name) {
        Member member = new Member(id, name);
        dao.insert(member);
    }
}
