package main.com.product.repository;

import main.com.config.MySqlSessionFactory;
import main.com.product.domain.Product;
import main.com.product.request.ProductSearch;
import main.com.product.response.ProductInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.stream.Collectors;

public class MySqlProductRepository implements ProductRepository{
    @Override
    public Product findById(Long id) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            Product product = sqlSession.selectOne("mapper.product.findById",id);
            return product;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public Product findByName(String productName) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            Product products= sqlSession.selectOne("mapper.product.findByName",productName);
            return products;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public List<Product> findIncludeName(String productName) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            List<Product> products= sqlSession.selectList("mapper.product.findIncludeName",productName);
            return products;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public List<ProductInfo> findProduct(ProductSearch search) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            return sqlSession.selectList("mapper.product.findProduct",search);
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }


    @Override
    public Long save(Product product) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.insert("mapper.product.insert", product);
            sqlSession.commit();
            return product.getId();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public List<Long> save(List<Product> products) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.insert("mapper.product.insertList", products);
            sqlSession.commit();
            return products.stream().map(Product::getId).collect(Collectors.toList());
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public Long update(Product product) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.update("mapper.product.update", product);
            sqlSession.commit();
            return product.getId();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public void delete(Long productId) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            int success = sqlSession.insert("mapper.product.delete", productId);
            sqlSession.commit();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public List<Long> delete(List<Long> productIds) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.delete("mapper.product.deleteList", productIds);
            sqlSession.commit();
            return productIds;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public void deleteAll(){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.insert("mapper.product.deleteAll");
            sqlSession.commit();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
