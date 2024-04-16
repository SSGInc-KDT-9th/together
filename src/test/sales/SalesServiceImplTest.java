package test.sales;

import main.com.config.AppConfig;
import main.com.sales.request.SalesSearch;
import main.com.sales.response.ClientSalesInfo;
import main.com.sales.response.ProductSalesInfo;
import main.com.sales.service.SalesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalesServiceImplTest {
    AppConfig appConfig =new AppConfig();
    SalesService salesService = appConfig.salesService();
    @Test
    @DisplayName("상품별 매출 조회")
    void test1() throws Exception {
        //given
        String productName = "";
        //when
        List<ProductSalesInfo> productSales = salesService.getProductSales(null,productName, null, null);
        //then
        Assertions.assertNotNull(productSales);
    }

    @Test
    @DisplayName("고객별 매출 조회")
    void test2() throws Exception {
        //given
        String clientName = "청운슈퍼";
        //when
        List<ClientSalesInfo> clientSales = salesService.getClientSales(null,clientName, null, null);
        //then
        Assertions.assertNotNull(clientSales);
    }
}