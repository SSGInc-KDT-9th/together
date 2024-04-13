package main.com.order.dto;

public class OrderDTO {
	int id;
	int release_id;
	int product_id;
	String order_date;
	int order_cnt;
	int client_id;
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(int id, int release_id, int product_id, 
			String order_date, int order_cnt, int client_id) {
		super();
		this.id = id;
		this.release_id = release_id;
		this.product_id = product_id;
		this.order_date = order_date;
		this.order_cnt = order_cnt;
		this.client_id = client_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRelease_id() {
		return release_id;
	}
	public void setRelease_id(int release_id) {
		this.release_id = release_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getOrder_cnt() {
		return order_cnt;
	}
	public void setOrder_cnt(int order_cnt) {
		this.order_cnt = order_cnt;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", release_id=" + release_id + ", product_id=" + product_id + ", order_date="
				+ order_date + ", order_cnt=" + order_cnt + ", client_id=" + client_id + "]";
	}
	
	
	
}
