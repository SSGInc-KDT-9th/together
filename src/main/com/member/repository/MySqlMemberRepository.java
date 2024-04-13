package main.com.member.repository;

import main.com.config.MySqlSessionFactory;
import main.com.member.domain.Member;
import org.apache.ibatis.session.SqlSession;

public class MySqlMemberRepository implements MemberRepository{

    public MySqlMemberRepository() {
    }

    @Override
    public long save(Member member) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.insert("mapper.member.insert",member);
            sqlSession.commit();
            return member.getId();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public Member findByMemberId(String memberId) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            Member member = sqlSession.selectOne("mapper.member.insert", memberId);
            sqlSession.commit();
            return member;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public int delete(String memberId) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            int success = sqlSession.delete("mapper.member.delete", memberId);
            sqlSession.commit();
            return success;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public void update(Member member) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.update("mapper.member.update", member);
            sqlSession.commit();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
