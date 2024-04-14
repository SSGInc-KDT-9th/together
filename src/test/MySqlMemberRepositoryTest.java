package test;

import main.com.member.domain.Member;
import main.com.member.domain.MemberRole;
import main.com.member.repository.MemberRepository;
import main.com.member.repository.MySqlMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlMemberRepositoryTest {
    MemberRepository memberRepository = new MySqlMemberRepository();
    @Test
    @DisplayName("멤버 추가/조회 테스트")
    void test1() throws Exception {
        //given
        Member member = new Member("김도영","test","1234", MemberRole.COMMON);
        Long id = memberRepository.save(member);
        //when
        Member expect = memberRepository.findByMemberId("test");
        memberRepository.delete(member);
        //then
        Assertions.assertEquals(expect.getId(),id);
        Assertions.assertEquals(expect.getMember_login_id(),member.getMember_login_id());
        Assertions.assertEquals(expect.getMember_password(),member.getMember_password());
        Assertions.assertEquals(expect.getMember_role(),member.getMember_role());
    }
}