package main.com.supplier.domain;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class SupplierDAO {

	public List<Supplier> supplierFindAll(SqlSession session, Supplier supplier){
		List<Supplier> list = session.selectList("SupplierFindAll", supplier);
		return list;
	}
	
	public int supplierInsert(SqlSession session, Supplier supplier) {
		return session.insert("SupplierInsert", supplier);
	}
	
	public void supplierUpdate(SqlSession session, Supplier supplier) {
		session.update("SupplierUpdate", supplier);
	};
	
    public int supplierDelete(SqlSession session, long id) {
    	return session.delete("SupplierDelete", id);
    };
	
}
