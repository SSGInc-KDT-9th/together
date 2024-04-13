package main.com.order.service;

import main.com.config.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import main.com.order.dao.OrderDAO;


public class OrderServiceImpl implements OrderService{
	
	private OrderDAO dao;
	@Override
	public void setDao(OrderDAO dao) {
		this.dao = dao;		
	}
//	@Override
//	public int findClientId() {
//		return 0;
//	}
	@Override
	public int findClientId(String company_name) {
		
		SqlSession session = null;
		int clientId = 0;
		try {
			session = MySqlSessionFactory.openSession();
//			if(session!=null) {
//				System.out.println("null아님");
//			}
			clientId = dao.findClientId(session, company_name);

		} finally {
			session.close();
		}
		return clientId;
	}

}
