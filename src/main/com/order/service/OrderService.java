package main.com.order.service;

import java.util.List;

import main.com.order.dao.OrderDAO;
import main.com.order.dto.OrderDTO;
import main.com.release.dto.ReleaseDTO;


public interface OrderService {
	public void setDao(OrderDAO dao);
	public int findClientId(String company_name);
	public int findProductId(String product_name);
	public int enrolltoorder(OrderDTO dto);
	public List<OrderDTO> orderselect(long releaseid);
	public String companyselect(int cid);
	public String productselect(int pid);

}
