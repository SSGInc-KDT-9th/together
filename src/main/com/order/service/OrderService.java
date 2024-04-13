package main.com.order.service;

import main.com.order.dao.OrderDAO;

public interface OrderService {
	public void setDao(OrderDAO dao);
//	public int findClientId();
	public int findClientId(String company_name);
}
