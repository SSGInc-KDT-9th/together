package test.prodcut;

import main.com.config.AppConfig;
import main.com.product.domain.Product;
import main.com.product.service.ProductServiceImpl;
import main.com.stock.domain.Stock;
import main.com.stock.domain.StockEdit;
import main.com.product.service.ProductService;
import main.com.stock.service.StockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StockServiceImplTest {
    AppConfig appConfig = new AppConfig();
    ProductService productService = appConfig.productService();
    StockService stockService = appConfig.stockService();
    @Test
    @DisplayName("재고 수정")
    void test1() throws Exception {
        //given
//        ProductCreate productCreate = ProductCreate.builder()
//                    .productName("테스트아이스크림")
//                    .supplierName("빙그레")
//                        .categoryId(47L)
//                                .build();
//        productService.save(productCreate);
        Product product = productService.get("테스트아이스크림");
        StockEdit stockEdit = StockEdit.builder()
                .inventory(100)
                .storePrice(100).build();

        //when
        stockService.editStore(product.getId(),stockEdit);
        //then
        Stock stock = stockService.getByProduct(product.getId());
        Assertions.assertEquals(stock.getInventory(),100);
    }

    @Test
    @DisplayName("출고 테스트")
    void test2() throws Exception {
        //given
        Product product = productService.get("테스트아이스크림");
        StockEdit stockEdit = StockEdit.builder()
                .inventory(50)
                .build();
        stockService.editRelease(product.getId(),stockEdit);
        //when
        Stock stock = stockService.getByProduct(product.getId());
        //then
        Assertions.assertEquals(stock.getInventory(),50);
    }
}