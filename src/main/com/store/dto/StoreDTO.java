package main.com.store.dto;

public class StoreDTO {
	private long id;
	private long product_id;
	private long member_id;
	private String store_date;
	private int store_count;
	private String status;
	private int store_price;
	
	public StoreDTO() {}

	public StoreDTO(long id, long product_id, long member_id, String store_date, int store_count, String status,
			int store_price) {
		this.id = id;
		this.product_id = product_id;
		this.member_id = member_id;
		this.store_date = store_date;
		this.store_count = store_count;
		this.status = status;
		this.store_price = store_price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getStore_date() {
		return store_date;
	}

	public void setStore_date(String store_date) {
		this.store_date = store_date;
	}

	public int getStore_count() {
		return store_count;
	}

	public void setStore_count(int store_count) {
		this.store_count = store_count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStore_price() {
		return store_price;
	}

	public void setStore_price(int store_price) {
		this.store_price = store_price;
	}
	
}
