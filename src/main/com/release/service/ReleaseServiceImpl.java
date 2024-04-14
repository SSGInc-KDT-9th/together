package main.com.release.service;

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
}
