package oop_test.ch01;

public class MemberDao {

    public void insert(Member member) {
        System.out.println(member.getName() + " 회원 정보가 DB에 저장되었습니다.");
    }
}
