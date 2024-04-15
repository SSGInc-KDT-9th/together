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

    public void update(SqlSession session, StoreDTO StoreDTO) {
        session.update("main.resource.mapper.StoreMapper.update", StoreDTO);
    }
    

    public int insert(SqlSession session, StoreDTO StoreDTO) {
        return session.insert("main.resource.mapper.StoreMapper.insert", StoreDTO);
    }

    public int delete(SqlSession session, int id) {
    	return session.delete("main.resource.mapper.StoreMapper.delete", id);
    }
}
