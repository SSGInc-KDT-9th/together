package main.com.product.repository;

import main.com.product.domain.Product;
import main.com.product.request.ProductSearch;
import main.com.product.response.ProductInfo;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    List<Product> findByName(String name);
    List<ProductInfo> findProduct(ProductSearch searchDTO);
    Long save(Product product);
    List<Long> save(List<Product> products);
    Long update(Product product);
    void delete(Long product);
    List<Long> delete(List<Long> products);
    void deleteAll();
}
