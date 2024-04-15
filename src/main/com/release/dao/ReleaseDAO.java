package main.com.release.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import main.com.release.dto.ReleaseDTO;

public class ReleaseDAO {
	 public int enroll(SqlSession session, ReleaseDTO dto) {
		 return session.insert("mapper.release.enroll", dto);
	 }
	 
	 public int findreleaseID(SqlSession session, int item_cnt){
		 int ReleaseId = session.selectOne("mapper.release.findreleaseID",item_cnt);
		 return ReleaseId;
	 }
	 public List<ReleaseDTO> noselect(SqlSession session, int id){
			List<ReleaseDTO> list = 
					session.selectList("mapper.release.noselect", id);
			return list;
		}
	 public List<ReleaseDTO> statuselect(SqlSession session, String status){
			List<ReleaseDTO> list = 
					session.selectList("mapper.release.statuselect", status);
			return list;
		}

	    public int releasedelete(SqlSession session, long id) {
	    	return session.delete("mapper.release.releasedelete", id);
	    }

		public List<ReleaseDTO> findall(SqlSession session) {
			List<ReleaseDTO> list2 = 
					session.selectList("mapper.release.findall");
			return list2;

		}
		public int Inventoryselect(SqlSession session, int product_id){
			 int inventory = session.selectOne("mapper.release.Inventoryselect",product_id);
			 return inventory;
		 }

		public int Inventoryupdate(SqlSession session, ReleaseDTO dto) {	
			return session.update("mapper.release.Inventoryupdate", dto);
		}
}
