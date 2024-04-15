package main.com.supplier.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import main.com.config.MySqlSessionFactory;
import main.com.supplier.domain.Supplier;
import main.com.supplier.repository.SupplierDAO;

public class SupplierServiceImpl implements SupplierService {

	private SupplierDAO supplierDao;
	public void setSup(SupplierDAO supplierDao) {
		this.supplierDao = supplierDao;
	}

	@Override
	public List<Supplier> supplierFindAll(Supplier supplier) {
		
		SqlSession session = null;
		List<Supplier> list = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			list = supplierDao.supplierFindAll(session, supplier);
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
			n = supplierDao.supplierInsert(session, supllier);
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
			supplierDao.supplierUpdate(session, supllier);
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
			n = supplierDao.supplierDelete(session, id);
			session.commit();
		}finally {
			session.clearCache();
		}
		return n;
	}
}
