package main.com.member.repository;

import main.com.member.domain.Member;

public interface MemberRepository {
    Long save(Member member);
    Member findByMemberId(String memberId);
    int delete(Member member);
    void update(Member member);
}
