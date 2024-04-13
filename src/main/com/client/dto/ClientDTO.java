package main.com.client.dto;

public class ClientDTO {

	int id;
	String company_name;
	String category;
	int income;
	String address;


	public ClientDTO() {}


	public ClientDTO(int id, String company_name, String category, int income, String address) {
		this.id = id;
		this.company_name = company_name;
		this.category = category;
		this.income = income;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getIncome() {
		return income;
	}


	public void setIncome(int income) {
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
		return "ClientDTO [id=" + id + ", company_name=" + company_name + ", category=" + category + ", income="
				+ income + ", address=" + address + "]";
	}





}