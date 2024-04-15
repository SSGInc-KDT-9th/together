package main.com.product.service;

public interface StockService {
    void getStorePrice();
    void getSellingPrice();
    void editStore(Integer price, Integer storeCount);
}
