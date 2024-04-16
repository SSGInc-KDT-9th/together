package main.com.config;
import main.com.member.repository.MemberRepository;
import main.com.member.repository.MySqlMemberRepository;
import main.com.member.service.MemberService;
import main.com.member.service.MemberServiceImpl;
import main.com.product.repository.CategoryRepository;
import main.com.product.repository.MySqlProductRepository;
import main.com.product.repository.ProductRepository;
import main.com.stock.repository.StockRepository;
import main.com.product.service.*;
import main.com.stock.service.StockService;
import main.com.stock.service.StockServiceImpl;
import main.com.supplier.repository.SupplierDAO;
import main.com.supplier.service.SupplierService;
import main.com.supplier.service.SupplierServiceImpl;


public class AppConfig {
    public ProductRepository productRepository(){
        return new MySqlProductRepository();
    }

    public StockRepository stockRepository(){
        return new StockRepository();
    }
    public StockService stockService(){
        return new StockServiceImpl(stockRepository(),productRepository());
    }
    public ProductService productService(){
        return new ProductServiceImpl(productRepository(),stockRepository());
    }

    public MemberRepository memberRepository(){
        return new MySqlMemberRepository();
    }

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public CategoryRepository categoryRepository(){
        return new CategoryRepository();
    }
    public CategoryService categoryService(){
        return new CategoryServiceImpl(categoryRepository());
    }

    public SupplierDAO supplierDAO(){
        return new SupplierDAO();
    }

    public SupplierService supplierService(){
        SupplierService supplierService = new SupplierServiceImpl();
        supplierService.setSup(supplierDAO());
        return supplierService;
    }

}
