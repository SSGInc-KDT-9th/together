package main.com.product.service;

import main.com.product.domain.Stock;
import main.com.product.domain.StockEdit;
import main.com.release.dto.ReleaseDTO;

public interface StockService {
    void getStorePrice();
    void getSellingPrice();
    void editStore(Long id, StockEdit stockEdit);
    void Inventoryupdate(Stock sto);
	void editStore(Integer price, Integer storeCount);
}
