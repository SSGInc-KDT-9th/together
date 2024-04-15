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
		
		SqlSession sqlSession = null;
		List<Supplier> list = null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			list = supplierDao.supplierFindAll(sqlSession, supplier);
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
				
		return list;
	}
	

	@Override
	public int insert(Supplier supllier) {
		int n = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.openSession();
			n = supplierDao.supplierInsert(sqlSession, supllier);
			sqlSession.commit();
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
		return n;
		
	}

	@Override
	public void update(Supplier supllier) {
		
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.openSession();
			supplierDao.supplierUpdate(sqlSession, supllier);
			sqlSession.commit();
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}

		
	}

	@Override
	public int delete(long id) {
		int n = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.openSession();
			n = supplierDao.supplierDelete(sqlSession, id);
			sqlSession.commit();
		}finally {
			sqlSession.rollback();
			sqlSession.clearCache();
		}
		return n;
	}
}
