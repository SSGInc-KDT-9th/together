package test.prodcut;

import main.com.config.AppConfig;
import main.com.product.repository.MySqlProductRepository;
import main.com.product.repository.ProductRepository;
import main.com.product.service.ProductService;
import main.com.product.service.ProductServiceImpl;
import main.com.product.service.StockService;
import main.com.product.service.StockServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockServiceImplTest {
    AppConfig appConfig = new AppConfig();
    ProductService productService = appConfig.productService();
    StockService stockService = appConfig.stockService();
    @Test
    @DisplayName("재고 수정")
    void test1() throws Exception {
        //given

        //when

        //then

    }
}