package main.com.config;
import main.com.member.repository.MemberRepository;
import main.com.member.repository.MySqlMemberRepository;
import main.com.member.service.MemberService;
import main.com.member.service.MemberServiceImpl;
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

    public MemberRepository memberRepository(){
        return new MySqlMemberRepository();
    }

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
}
