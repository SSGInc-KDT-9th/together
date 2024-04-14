package main.com.product.repository;

import main.com.config.MySqlSessionFactory;
import main.com.product.domain.Category;
import main.com.product.domain.Product;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryRepository {
    public Category findById(Long id) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            Category category = sqlSession.selectOne("mapper.category.findById",id);
            return category;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public Category findByName(String categoryName) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            Category category = sqlSession.selectOne("mapper.category.findByName",categoryName);
            return category;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public List<Category> findParent() {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            List<Category> categories=  sqlSession.selectList("mapper.category.findParent");
            return categories;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public List<Category> findChild() {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            List<Category> categories=  sqlSession.selectList("mapper.category.findChild");
            sqlSession.commit();
            return categories;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public Long save(Category category) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.insert("mapper.category.insert",category);
            sqlSession.commit();
            return category.getCategoryId();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public Long update(Category category){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.update("mapper.category.update",category);
            sqlSession.commit();
            return category.getCategoryId();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public void delete(Long id){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.update("mapper.category.delete",id);
            sqlSession.commit();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
