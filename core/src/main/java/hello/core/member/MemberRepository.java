package hello.core.member;

public interface MemberRepository {

    void save(Member member);//멤버저장

    Member findById(Long memberId);//멤버찾기
}
