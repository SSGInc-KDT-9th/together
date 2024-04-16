package main.com.store.service;

import java.util.List;

import main.com.store.dao.StoreDAO;
import main.com.store.dto.StoreDTO;

public interface StoreService {

    public void setDao(StoreDAO dao);
    public List<StoreDTO> findAll();
    public List<StoreDTO> findStore(StoreDTO storeDTO);
    public StoreDTO findById(long id);
    public List<StoreDTO> findByProductName(String productName);
    int insert(StoreDTO storeDTO);
    int update(StoreDTO storeDTO);
    public int delete(long id);
	
}
