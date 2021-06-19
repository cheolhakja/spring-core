package hongik.corestudy100.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
