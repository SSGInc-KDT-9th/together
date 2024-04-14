package main.com.order.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import main.com.config.MySqlSessionFactory;
import main.com.order.dao.OrderDAO;
//import main.com.product.dao.ProductDAO;
import main.com.order.dto.OrderDTO;
import main.com.release.dto.ReleaseDTO;


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

	@Override
	public int enrolltoorder(OrderDTO dto) {
		int n2 = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.openSession();
			//DAO 연동코드
			n2 = dao.enrolltoorder(session, dto);
			session.commit();
	      }finally {
			session.close();
	      }
		return n2;
	}

	@Override
	public List<OrderDTO> orderselect(long id) {
		List<OrderDTO> list = null;
		SqlSession session = null;
		
		  try {
				session = MySqlSessionFactory.openSession();
				//DAO 연동코드
				list = dao.orderselect(session, id);
		      }finally {
				session.close();
		      }
				return list;
	}

	@Override
	public String companyselect(OrderDTO id) {
		SqlSession session = null;
		String cname = null;
  
		try {
			session = MySqlSessionFactory.openSession();
			cname = dao.companyselect(session, id);

		} finally {
			session.close();
		}
		return cname;
	}

	@Override
	public String productselect(OrderDTO id) {
		SqlSession session = null;
		String pname = null;
  
		try {
			session = MySqlSessionFactory.openSession();
			pname = dao.productselect(session, id);

		} finally {
			session.close();
		}
		return pname;
	}
	
}

