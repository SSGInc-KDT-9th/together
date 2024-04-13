package main.com.supplier.domain;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class SupplierDAO {

	public List<Supplier> findAll(SqlSession session){
		List<Supplier> list = session.selectList("findAll");
		return list;
	}
	
	public int insert(SqlSession session, Supplier supplier) {
		return session.insert("insert", supplier);
	}
	
	public void update(SqlSession session, Supplier supplier) {
		session.update("update", supplier);
	};
	
    public int delete(SqlSession session, long id) {
    	return session.delete("delete", id);
    };
	
}
