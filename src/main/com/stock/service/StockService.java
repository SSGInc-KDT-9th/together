package main.com.stock.service;

import main.com.stock.domain.Stock;
import main.com.stock.domain.StockEdit;

public interface StockService {
    Stock get(Long id);
    Stock getByProduct(Long productId);
    void delete(Long id);
    void delete(String productName);
    void editStore(Long id, StockEdit stockEdit);
}
