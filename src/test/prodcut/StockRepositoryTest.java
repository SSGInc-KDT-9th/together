package test.prodcut;

import main.com.product.domain.Product;
import main.com.product.domain.Stock;
import main.com.product.domain.StockEdit;
import main.com.product.repository.MySqlProductRepository;
import main.com.product.repository.ProductRepository;
import main.com.product.repository.StockRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StockRepositoryTest {
    ProductRepository productRepository = new MySqlProductRepository();
    StockRepository stockRepository = new StockRepository();

    @Test
    @DisplayName("전체 조회 테스트")
    void test1() throws Exception {
        //given
        List<Stock> all = stockRepository.findAll();
        //when
        Assertions.assertNotNull(all.size());
        //then

    }
    @Test
    @DisplayName("재고 삽입 테스트")
    void test2() throws Exception {
        //given
        Stock stock = Stock.builder()
                .productId(7L)
                .modifiedDate(LocalDateTime.now().withNano(0))
                .inventory(0)
                .build();
        //when
        Long saveStockId = stockRepository.save(stock);
        Stock expect = stockRepository.findById(stock.getId());
        stockRepository.delete(saveStockId);
        //then
        Assertions.assertEquals(expect.getId(),saveStockId);
        Assertions.assertEquals(expect.getModifiedDate(),stock.getModifiedDate());
        Assertions.assertEquals(expect.getInventory(),stock.getInventory());
    }
    
    @Test
    @DisplayName("재고 수정 테스트")
    void test3() throws Exception {
        //given
        Stock stock = Stock.builder()
                .productId(7L)
                .modifiedDate(LocalDateTime.now().withNano(0))
                .inventory(0)
                .build();
        Long id = stockRepository.save(stock);
        //when
        StockEdit.StockEditBuilder builder = stock.toEditor();
        StockEdit stockEditor = builder.inventory(100).build();
        stock.edit(stockEditor);

        stockRepository.update(stock);
        stockRepository.delete(id);
        //then
        Assertions.assertEquals(stock.getInventory(),100);
    }
}