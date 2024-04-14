package main.com.client.service;

import main.com.client.dao.ClientDAO;
import main.com.client.dto.ClientDTO;
import main.com.config.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDAO dao;
    @Override
    public void setDao(ClientDAO dao) {
        this.dao=dao;

    }

    //전체조회 메서드
    @Override
    public List<ClientDTO> findAll() {
        List<ClientDTO> list = null;
        SqlSession session = null;
        try {
            session = MySqlSessionFactory.openSession();
            //DAO 연동코드
            list = dao.findAll(session);
            System.out.println(list);
        }finally {
            session.close();
        }
        return list;
    }

    //id를 통한 고객기업 삭제 메서드
    @Override
    public int removeByid(int id) {
        int n = 0;
        SqlSession session = null;
        try {
            session = MySqlSessionFactory.openSession();
            //DAO 연동코드
            n = dao.removeByid(session, id);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }

	@Override
	public int insert(ClientDTO ClientDTO) {
		 int n = 0;
	        SqlSession session = null;
	        try {
	            session = MySqlSessionFactory.openSession();
	            //DAO 연동코드
	            n = dao.insert(session, ClientDTO);
	            session.commit();
	        }finally {
	            session.close();
	        }
	        return n;
	}

	@Override
	public void update(ClientDTO ClientDTO) {
	        SqlSession session = null;
	        try {
	            session = MySqlSessionFactory.openSession();
	            //DAO 연동코드
	            dao.update(session, ClientDTO);
	            session.commit();
	        }finally {
	            session.close();
	        }
		
	}



}
