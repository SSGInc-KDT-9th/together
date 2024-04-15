package main.com.product.service;

import main.com.product.domain.Stock;
import main.com.product.domain.StockEdit;
import main.com.product.repository.StockRepository;

public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void getStorePrice() {

    }

    @Override
    public void getSellingPrice() {

    }

    @Override
    public void editStore(Long id, StockEdit stockEdit) {
        Stock stock = stockRepository.findById(id);
        StockEdit.StockEditBuilder editorBuilder = stock.toEditor();
        int currentTotalPrice = stock.getStorePrice()*stock.getInventory();
        int addTotalPrice = stockEdit.getStorePrice()*stockEdit.getInventory();
        int meanPrice = (currentTotalPrice+addTotalPrice)/(stock.getInventory()+ stock.getInventory());

        StockEdit stockEditor = editorBuilder.inventory(stockEdit.getInventory())
                .storePrice(meanPrice)
                .build();

        stock.edit(stockEditor);
        stockRepository.update(stock);
    }
}
