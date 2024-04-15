package main.com.release.service;

import java.util.List;

import main.com.release.dao.ReleaseDAO;
import main.com.release.dto.ReleaseDTO;


public interface ReleaseService {
	public void setDao(ReleaseDAO dao);
	public int enroll(ReleaseDTO dto);
	public int findreleaseID(int item_cnt);
//	public List<ReleaseDTO> getReleaseWithMember();
	public List<ReleaseDTO> noselect(int id);
	public List<ReleaseDTO> statuselect(String status);
	public int releasedelete(long releaseid);
	public List<ReleaseDTO> findall();
	public int Inventoryselect(int product_id);
	public int Inventoryupdate(ReleaseDTO dto);
	public void updatestatus(long id);
}
