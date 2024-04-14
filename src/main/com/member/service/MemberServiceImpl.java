package main.com.member.service;

import main.com.member.domain.Member;
import main.com.member.repository.MemberRepository;
import main.com.member.repository.MySqlMemberRepository;

public class MemberServiceImpl implements MemberService{
    MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long join(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public boolean login(String loginId, String password) {
        Member findMember = memberRepository.findByMemberId(loginId);
        if(findMember.getMember_login_id().equals(loginId)
                && findMember.getMember_password().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public Member findMember(String loginId) {
         return memberRepository.findByMemberId(loginId);
    }

    @Override
    public boolean validMemberId(String loginId) {
        Member member = memberRepository.findByMemberId(loginId);
        return member == null;
    }
}
