package test.prodcut;

import main.com.config.AppConfig;
import main.com.product.domain.Product;
import main.com.product.request.ProductCreate;
import main.com.product.request.ProductSearch;
import main.com.product.response.ProductInfo;
import main.com.product.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    AppConfig appConfig = new AppConfig();
    ProductService productService = appConfig.productService();
    @Test
    @DisplayName("상품 조회 테스트")
    void test1() throws Exception {
        //given
        ProductSearch search = ProductSearch.builder().build();
        //when
        List<ProductInfo> products = productService.search(search);
        //then
        Assertions.assertEquals(products.size(),1);
    }

    @Test
    @DisplayName("상품 등록 테스트")
    void test2() throws Exception {
        //given
        ProductCreate product = ProductCreate.builder()
                .productName("상품서비스테스트2")
                .supplierName("빙그레")
                .build();
        //when
        productService.save(product);
        Product expect = productService.get("상품서비스테스트2");
        productService.delete(ProductInfo.builder().id(expect.getId()).build());
        //then
        Assertions.assertEquals(expect.getProductName(),"상품서비스테스트2");
    }
}