package main.com.order.dto;

public class OrderDTO {
	int id;
	int release_id;
	int product_id;
	String order_date;
	int order_cnt;
	String company_name;

	
	
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(int id, int release_id, int product_id, 
			String order_date, int order_cnt, String company_name) {
		super();
		this.id = id;
		this.release_id = release_id;
		this.product_id = product_id;
		this.order_date = order_date;
		this.order_cnt = order_cnt;
		this.company_name = company_name;
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
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", release_id=" + release_id + ", product_id=" + product_id + ", order_date="
				+ order_date + ", order_cnt=" + order_cnt + ", company_name=" + company_name + "]";
	}
	
	
	
}
