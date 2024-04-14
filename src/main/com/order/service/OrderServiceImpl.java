package main.com.order.service;

import org.apache.ibatis.session.SqlSession;

import main.com.config.MySqlSessionFactory;
import main.com.order.dao.OrderDAO;
//import main.com.product.dao.ProductDAO;


public class OrderServiceImpl implements OrderService{
	
	private OrderDAO dao = new OrderDAO();
	@Override
	public void setDao(OrderDAO dao) {
		this.dao = dao;		
	}

	@Override
	public int findClientId(String company_name) {

		SqlSession session = null;
		int clientId = 0;
  
		try {
			session = MySqlSessionFactory.openSession();
			clientId = dao.findClientId(session, company_name);

		} finally {
			session.close();
		}
		return clientId;
	}


	@Override
	public int findProductId(String product_name) {
		SqlSession session = null;
		int productId = 0;
  
		try {
			session = MySqlSessionFactory.openSession();
			productId = dao.findProductId(session, product_name);

		} finally {
			session.close();
		}
		return productId;
	}

}
