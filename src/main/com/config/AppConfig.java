package main.com.config;
import main.com.product.repository.MySqlProductRepository;
import main.com.product.repository.ProductRepository;
import main.com.product.service.ProductService;
import main.com.product.service.ProductServiceImpl;

public class AppConfig {
    public ProductRepository productRepository(){
        return new MySqlProductRepository();
    }

    public ProductService productService(){
        return new ProductServiceImpl(productRepository());
    }
}
