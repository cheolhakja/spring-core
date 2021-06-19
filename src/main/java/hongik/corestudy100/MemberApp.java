package hongik.corestudy100;

import hongik.corestudy100.member.Grade;
import hongik.corestudy100.member.Member;
import hongik.corestudy100.member.MemberService;
import hongik.corestudy100.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println( "memberA name : " + member.getName());
        System.out.println("findMember name : " + findMember.getName());
    }
}
