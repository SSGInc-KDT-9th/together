package main.com.client.dao;

import java.util.List;

import main.com.client.dto.ClientDTO;
import org.apache.ibatis.session.SqlSession;


public class ClientDAO {

    //전체 고객기업 조회
    public List<ClientDTO> findAll(SqlSession session){
        List<ClientDTO> list =
                session.selectList("com.config.cc.ClientMapper.findAll");
        return list;
    }

    //기업 id를 통한 기업 삭제
    public int removeByid(SqlSession session, int id) {
        return session.delete("com.config.cc.ClientMapper.removeByid", id);
    }


}