package main.com.release.dao;

import org.apache.ibatis.session.SqlSession;

import main.com.release.dto.ReleaseDTO;

public class ReleaseDAO {
	 public int enroll(SqlSession session, ReleaseDTO dto) {
		 return session.insert("mapper.release.enroll", dto);
	 }
}
