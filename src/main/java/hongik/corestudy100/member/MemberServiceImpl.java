package hongik.corestudy100.member;

import hongik.corestudy100.AppConfig;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository ;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용 메서드
    public MemberRepository getMemberRepository() {
        return this.memberRepository;

    }
}
