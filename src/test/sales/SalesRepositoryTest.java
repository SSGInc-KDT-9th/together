package test.sales;

import main.com.sales.dto.ClientSales;
import main.com.sales.dto.ProductSales;
import main.com.sales.repository.SalesRepository;
import main.com.sales.request.SalesSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalesRepositoryTest {
    SalesRepository salesRepository = new SalesRepository();

    @Test
    @DisplayName("세일즈 상품 번호로 조회 테스트")
    void test1() throws Exception {
        //given
        SalesSearch salesSearch = SalesSearch.builder()
                .productId(372L).build();
        //when
        List<ProductSales> productSales = salesRepository.findByProduct(salesSearch);
        //then
        Assertions.assertNotNull(productSales);
    }


    @Test
    @DisplayName("세일즈 상품 전체 조회 테스트")
    void test2() throws Exception {
        //given
        SalesSearch salesSearch = SalesSearch.builder().build();
        //when
        List<ProductSales> productSales = salesRepository.findByProduct(salesSearch);
        //then
        Assertions.assertNotNull(productSales);
    }

    @Test
    @DisplayName("세일즈 상품 번호로 조회 테스트")
    void test3() throws Exception {
        //given
        SalesSearch salesSearch = SalesSearch.builder()
                .clientId(1L).build();
        //when
        List<ClientSales> productSales = salesRepository.findByClient(salesSearch);
        //then
        Assertions.assertNotNull(productSales);
    }

    @Test
    @DisplayName("세일즈 상품 전체 조회 테스트")
    void test4() throws Exception {
        //given
        SalesSearch salesSearch = SalesSearch.builder().build();
        //when
        List<ClientSales> productSales = salesRepository.findByClient(salesSearch);
        //then
        Assertions.assertNotNull(productSales);
    }
}