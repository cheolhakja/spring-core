package hongik.corestudy100.member;

import hongik.corestudy100.member.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<Long, Member>();

    @Override
    public void save(Member member){
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId){
        return store.get(memberId);


    }
}
