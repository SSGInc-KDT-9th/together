package main.com.product.service;

import main.com.product.domain.Product;
import main.com.product.domain.ProductEdit;
import main.com.product.request.ProductCreate;
import main.com.product.request.ProductSearch;
import main.com.product.response.ProductInfo;

import java.util.List;

public interface ProductService {
    void save(ProductCreate productCreate);
    Product get(Long id);
    List<ProductInfo> getList(ProductSearch productSearch);

    void edit(Long id, ProductEdit productEdit);

    void delete(ProductInfo id);
    void delete(List<ProductInfo> ids);
}
