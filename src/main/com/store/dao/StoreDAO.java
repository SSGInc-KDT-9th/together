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
    
    public List<StoreDTO> findStore(SqlSession session, StoreDTO storeDTO){
        List<StoreDTO> list =
                session.selectList("main.resource.mapper.StoreMapper.findStore");
        return list;
    }
    
    public StoreDTO findById(SqlSession session, long id){
    	return session.selectOne("main.resource.mapper.StoreMapper.findById", id);
    }
    
    public List<StoreDTO> findByProductName(SqlSession session, String productName){
    	return session.selectList("main.resource.mapper.StoreMapper.findByProductName", productName);
    }

    public void update(SqlSession session, StoreDTO StoreDTO) {
        session.update("main.resource.mapper.StoreMapper.update", StoreDTO);
    }
    

    public int insert(SqlSession session, StoreDTO StoreDTO) {
        return session.insert("main.resource.mapper.StoreMapper.insert", StoreDTO);
    }

    public int delete(SqlSession session, long id) {
    	return session.delete("main.resource.mapper.StoreMapper.delete", id);
    }
}
