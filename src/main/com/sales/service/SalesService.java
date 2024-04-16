package main.com.sales.service;

import main.com.sales.request.SalesSearch;
import main.com.sales.response.ClientSalesInfo;
import main.com.sales.response.ProductSalesInfo;

import java.util.List;

public interface SalesService {
    List<ProductSalesInfo> getProductSales(SalesSearch salesSearch);
    List<ClientSalesInfo> getClientSales(SalesSearch salesSearch);
}
