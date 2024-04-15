package main.com.release.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import main.com.config.MySqlSessionFactory;
import main.com.release.dao.ReleaseDAO;
import main.com.release.dto.ReleaseDTO;

public class ReleaseServiceImpl implements ReleaseService {

	private ReleaseDAO dao = new ReleaseDAO();

	@Override
	public void setDao(ReleaseDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int enroll(ReleaseDTO dto) {
		int n = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.openSession();
			//DAO 연동코드
			n = dao.enroll(session, dto);
			session.commit();
	      }finally {
			session.close();
	      }
		return n;
	}

	@Override
	public int findreleaseID(int item_cnt) {
		SqlSession session = null;
		int releaseId = 0;
  
		try {
			session = MySqlSessionFactory.openSession();
			releaseId = dao.findreleaseID(session, item_cnt);

		} finally {
			session.close();
		}
		return releaseId;
	}

	@Override
	public List<ReleaseDTO> noselect(int id) {
		List<ReleaseDTO> list = null;
		SqlSession session = null;
		
		  try {
				session = MySqlSessionFactory.openSession();
				//DAO 연동코드
				list = dao.noselect(session, id);
		      }finally {
				session.close();
		      }
				return list;
			}

	@Override
	public List<ReleaseDTO> statuselect(String status) {
		List<ReleaseDTO> list = null;
		SqlSession session = null;
		
		  try {
				session = MySqlSessionFactory.openSession();
				//DAO 연동코드
				list = dao.statuselect(session, status);
		      }finally {
				session.close();
		      }
				return list;
	}

	@Override
	public int releasedelete(long id) {
		int n4 = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.openSession();
			//DAO 연동코드
			n4 = dao.releasedelete(session, id);
			session.commit();
	      }finally {
			session.close();
	      }
		return n4;
	}
	@Override
	public List<ReleaseDTO> findall() {
	 List<ReleaseDTO> list2 = null;	
	 SqlSession session = null;
      try {
		session = MySqlSessionFactory.openSession();
		//DAO 연동코드
		list2 = dao.findall(session);
      }finally {
		session.close();
      }
		return list2;
	}

	@Override
	public int Inventoryselect(int product_id) {
		SqlSession session = null;
		int inventory = 0;
  
		try {
			session = MySqlSessionFactory.openSession();
			inventory = dao.findreleaseID(session, product_id);

		} finally {
			session.close();
		}
		return inventory;
	}

	@Override
	public int Inventoryupdate(ReleaseDTO dto) {
		int n = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.openSession();
			//DAO 연동코드
			n = dao.Inventoryupdate(session, dto);
			session.commit();
	      }finally {
			session.close();
	      }
		return n;
}
}