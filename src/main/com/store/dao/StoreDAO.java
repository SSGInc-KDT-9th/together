package main.com.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import main.com.store.dto.StoreDTO;

public class StoreDAO {
	

    public List<StoreDTO> findAll(SqlSession session){
        List<StoreDTO> list =
                session.selectList("main.resource.mapper.StoreMapper.findAll");
        return list;
    }

    //고객기업 id를 통한 정보 수정
    public void update(SqlSession session, StoreDTO StoreDTO) {
        session.update("main.resource.mapper.StoreMapper.update", StoreDTO);
    }
    
    //고객기업 저장
    public int insert(SqlSession session, StoreDTO StoreDTO) {
        return session.insert("main.resource.mapper.StoreMapper.insert", StoreDTO);
    }
    
    //고객기업 id를 통한 삭제
    public int delete(SqlSession session, int id) {
    	return session.delete("main.resource.mapper.StoreMapper.delete", id);
    }
}
