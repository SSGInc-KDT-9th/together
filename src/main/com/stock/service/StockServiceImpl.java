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
    public void editStore(Long productId, StockEdit stockEdit) {
        Stock stock = stockRepository.findByProductId(productId);
        StockEdit.StockEditBuilder editorBuilder = stock.toEditor();


        StockEdit stockEditor = editorBuilder.inventory(stockEdit.getInventory())
                .storePrice(stockEdit.getStorePrice())
                .sellingPrice(stockEdit.getStorePrice()*2)
                .build();

        stock.edit(stockEditor);
        stockRepository.update(stock);
    }

    @Override
    public void editRelease(Long productId, StockEdit stockEdit) {
        Stock stock = stockRepository.findByProductId(productId);
        StockEdit.StockEditBuilder editorBuilder = stock.toEditor();

        StockEdit stockEditor = editorBuilder
                .inventory(stockEdit.getInventory())
                .build();

        stock.edit(stockEditor);
        stockRepository.update(stock);
    }
}
