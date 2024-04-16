package main.com.store.service;

import java.util.List;

import main.com.store.dao.StoreDAO;
import main.com.store.dto.StoreDTO;

public interface StoreService {

    public void setDao(StoreDAO dao);
    public List<StoreDTO> findAll();
    int insert(StoreDTO StoreDTO);
    int update(StoreDTO StoreDTO);
    public int delete(int id);
	
}
