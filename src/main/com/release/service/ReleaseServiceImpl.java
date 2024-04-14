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

}
