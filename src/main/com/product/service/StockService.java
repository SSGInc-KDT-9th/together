package main.com.product.service;

import main.com.product.domain.StockEdit;

public interface StockService {
    void getStorePrice();
    void getSellingPrice();
    void editStore(Long id, StockEdit stockEdit);
}
