package main.com.client.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import main.com.client.dto.ClientDTO;
import main.com.config.MySqlSessionFactory;


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
    public int update(SqlSession session, ClientDTO ClientDTO) {
       return session.update("main.resource.mapper.ClientMapper.update", ClientDTO);
    }
    
    //고객기업 저장
    public int insert(SqlSession session, ClientDTO ClientDTO) {
        return session.insert("main.resource.mapper.ClientMapper.insert", ClientDTO);
    }
    
    //고객기업 id를 통한 정보 조회
    public ClientDTO findById(SqlSession session, int id) {
        return session.selectOne("main.resource.mapper.ClientMapper.findById", id);
    }

    //고객 기업명을 통한 정보 조회
    public List<ClientDTO> findByCompanyName(SqlSession session, String companyName) {
        return session.selectList("main.resource.mapper.ClientMapper.findByCompanyName", companyName);
    }
    
    
}