package main.com.supplier.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import main.com.supplier.domain.Supplier;

public class SupplierDAO {

	public List<Supplier> supplierFindAll(SqlSession sqlSession, Supplier supplier){
		List<Supplier> list = sqlSession.selectList("SupplierFindAll", supplier);
		return list;
	}
	
	public int supplierInsert(SqlSession sqlSession, Supplier supplier) {
		return sqlSession.insert("SupplierInsert", supplier);
	}
	
	public void supplierUpdate(SqlSession sqlSession, Supplier supplier) {
		sqlSession.update("SupplierUpdate", supplier);
	};
	
    public int supplierDelete(SqlSession sqlSession, long id) {
    	return sqlSession.delete("SupplierDelete", id);
    };
	
}
