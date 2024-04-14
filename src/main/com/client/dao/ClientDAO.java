package main.com.client.dao;

import java.util.List;

import main.com.client.dto.ClientDTO;
import org.apache.ibatis.session.SqlSession;


public class ClientDAO {

    //전체 고객기업 조회
    public List<ClientDTO> findAll(SqlSession session){
        List<ClientDTO> list =
                session.selectList("main.resource.mapper.ClientMapper.findAll");
        return list;
    }

    //고객기업 id를 통한 삭제
    public int removeByid(SqlSession session, int id) {
        return session.delete("main.resource.mapper.ClientMapper.removeByid", id);
    }


    //고객기업 id를 통한 정보 수정
    public void update(SqlSession session, ClientDTO ClientDTO) {
        session.update("main.resource.mapper.ClientMapper.update", ClientDTO);
    }
    
    //고객기업 저장
    public int insert(SqlSession session, ClientDTO ClientDTO) {
        return session.insert("main.resource.mapper.ClientMapper.insert", ClientDTO);
    }
    
    
}