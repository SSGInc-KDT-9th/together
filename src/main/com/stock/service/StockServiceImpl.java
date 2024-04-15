package main.com.stock.service;

import main.com.product.domain.Product;
import main.com.product.repository.ProductRepository;
import main.com.stock.domain.Stock;
import main.com.stock.domain.StockEdit;
import main.com.stock.repository.StockRepository;

public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    public StockServiceImpl(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Stock get(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public Stock getByProduct(Long productId) {
        return stockRepository.findByProductId(productId);
    }

    @Override
    public void delete(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public void delete(String productName) {
        Product product = productRepository.findByName(productName);
        stockRepository.deleteByProductId(product.getId());
    }

    @Override
    public void editStore(Long id, StockEdit stockEdit) {
        Stock stock = stockRepository.findByProductId(id);
        StockEdit.StockEditBuilder editorBuilder = stock.toEditor();
        int currentTotalPrice = stock.getStorePrice()*stock.getInventory();
        int addTotalPrice = stockEdit.getStorePrice()*stockEdit.getInventory();
        int meanPrice = (currentTotalPrice+addTotalPrice)/(stock.getInventory()+ stockEdit.getInventory());

        StockEdit stockEditor = editorBuilder.inventory(stockEdit.getInventory())
                .storePrice(meanPrice)
                .build();

        stock.edit(stockEditor);
        stockRepository.update(stock);
    }
}
