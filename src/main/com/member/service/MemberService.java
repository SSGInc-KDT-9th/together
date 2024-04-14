package main.com.member.service;

import main.com.config.AppConfig;
import main.com.member.domain.Member;
import main.com.member.repository.MemberRepository;

public interface MemberService {
    Long join(Member member);
    boolean login(String loginId,String password);
    Member findMember(String loginId);
    boolean validMemberId(String loginId);
}
