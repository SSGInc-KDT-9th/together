package main.com.supplier.domain;

public class Supplier {

	private long id;
	private String company_name;
	private String company_category;
	private long income;
	private String address;
	
	public Supplier(long id, String company_name, String company_category, long income, String address) {
		this.id = id;
		this.company_name = company_name;
		this.company_category = company_category;
		this.income = income;
		this.address = address;
	}

	public Supplier() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_category() {
		return company_category;
	}

	public void setCompany_category(String company_category) {
		this.company_category = company_category;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Supliier [id=" + id + ", company_name=" + company_name + ", company_category=" + company_category
				+ ", income=" + income + ", address=" + address + "]";
	}
	
		
}
