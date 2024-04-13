package main.com.member.repository;

import main.com.member.domain.Member;

public interface MemberRepository {
    long save(Member member);
    Member findByMemberId(String memberId);
    int delete(String memberId);
    void update(Member member);
}
