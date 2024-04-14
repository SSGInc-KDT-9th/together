package main.com.supplier.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import main.com.config.MySqlSessionFactory;
import main.com.supplier.domain.Supplier;
import main.com.supplier.domain.SupplierDAO;

public class SupplierServiceImpl implements SupplierService {

	private SupplierDAO sup;
	public void setSup(SupplierDAO sup) {
		this.sup = sup;
	}

	@Override
	public List<Supplier> supplierFindAll(Supplier supplier) {
		
		SqlSession session = null;
		List<Supplier> list = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			list = sup.supplierFindAll(session, supplier);
		}finally {
			session.close();
		}
				
		return list;
	}
	

	@Override
	public int insert(Supplier supllier) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			n = sup.supplierInsert(session, supllier);
			session.commit();
		}finally {
			session.close();
		}
		return n;
		
	}

	@Override
	public void update(Supplier supllier) {
		
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			sup.supplierUpdate(session, supllier);
			session.commit();
		}finally {
			session.close();
		}

		
	}

	@Override
	public int delete(long id) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			n = sup.supplierDelete(session, id);
			session.commit();
		}finally {
			session.clearCache();
		}
		return n;
	}
}
