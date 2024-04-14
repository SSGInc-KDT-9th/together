package main.com.release.service;

import main.com.release.dao.ReleaseDAO;
import main.com.release.dto.ReleaseDTO;


public interface ReleaseService {
	public void setDao(ReleaseDAO dao);
	public int enroll(ReleaseDTO dto);
}
