package main.com.store.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import main.com.config.MySqlSessionFactory;
import main.com.store.dao.StoreDAO;
import main.com.store.dto.StoreDTO;

public class StoreServiceImpl implements StoreService{

	private StoreDAO dao;
	
	@Override
	public void setDao(StoreDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<StoreDTO> findAll() {
		List<StoreDTO> list = null;
		SqlSession session = null;
		try {
		  session = MySqlSessionFactory.openSession();
		  list = dao.findAll(session);
		}finally{
			session.rollback();
			session.close();
		}
		return list;
	}


	@Override
	public int insert(StoreDTO StoreDTO) {
		 int n = 0;
	        SqlSession session = null;
	        try {
	            session = MySqlSessionFactory.openSession();
	            n = dao.insert(session, StoreDTO);
	            session.commit();
	        }finally {
	        	session.rollback();
	            session.close();
	        }
	        return n;
	}

	@Override
	public int update(StoreDTO StoreDTO) {
			int result = 0;
	        SqlSession session = null;
	        try {
	            session = MySqlSessionFactory.openSession();
	            dao.update(session, StoreDTO);
	            session.commit();
	        }finally {
	        	session.rollback();
	            session.close();
	        }
	        return result;
		
	}

	@Override
	public int delete(long id) {
	       int n = 0;
	        SqlSession session = null;
	        try {
	            session = MySqlSessionFactory.openSession();
	            n = dao.delete(session, id);
	            session.commit();
	        }finally {
	        	session.rollback();
	            session.close();
	        }
	        return n;
	}

	@Override
	public StoreDTO findById(long id) {
		StoreDTO store = null;
		SqlSession session = null;
		try {
		  session = MySqlSessionFactory.openSession();
		  store = dao.findById(session, id);
		}finally{
			session.rollback();
			session.close();
		}
		return store;

	}

	@Override
	public List<StoreDTO> findByProductName(String productName) {
		List<StoreDTO> list = null;
		SqlSession session = null;
		try {
		  session = MySqlSessionFactory.openSession();
		  list = dao.findByProductName(session,productName);
		}finally{
			session.rollback();
			session.close();
		}
		return list;
	}

}
