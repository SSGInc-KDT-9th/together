package main.com.stock.repository;

import main.com.config.MySqlSessionFactory;
import main.com.stock.domain.Stock;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StockRepository {
    public Stock findById(Long id){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("mapper.stock.findById", id);
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public Stock findByProductId(Long productId){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("mapper.stock.findByProduct", productId);
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public List<Stock> findAll(){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            return sqlSession.selectList("mapper.stock.findAll");
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public Long update(Stock stock){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.update("mapper.stock.update",stock);
            sqlSession.commit();
            return stock.getId();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public Long save(Stock stock){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.insert("mapper.stock.insert",stock);
            sqlSession.commit();
            return stock.getId();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public void deleteById(Long id){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.update("mapper.stock.deleteById",id);
            sqlSession.commit();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public void deleteByProductId(Long productId){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            sqlSession.update("mapper.stock.deleteByProduct",productId);
            sqlSession.commit();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    public void Inventoryupdate(Stock sto) {
    	 SqlSession sqlSession = MySqlSessionFactory.openSession();
         try {
             sqlSession.update("mapper.stock.Inventoryupdate", sto);
             sqlSession.commit();
         }
         finally{
             sqlSession.rollback();
             sqlSession.close();
         }
    }

}
