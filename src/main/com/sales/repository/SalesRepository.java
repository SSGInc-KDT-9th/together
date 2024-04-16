package main.com.sales.repository;

import main.com.config.MySqlSessionFactory;
import main.com.sales.dto.ClientSales;
import main.com.sales.dto.ProductSales;
import main.com.sales.request.SalesSearch;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SalesRepository {
    public List<ProductSales> findByProduct(SalesSearch salesSearch){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            List<ProductSales> sales = sqlSession.selectList("mapper.sales.findProductSales", salesSearch);
            return sales;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public List<ClientSales> findByClient(SalesSearch salesSearch){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            List<ClientSales> sales = sqlSession.selectList("mapper.sales.findClientSales",salesSearch);
            return sales;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}
