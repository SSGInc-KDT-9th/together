package main.com.release.dto;

public class ReleaseDTO {
	int id;
	long member_id;
	String release_date;
	String status;
	int item_cnt;
	int company_id;
	public ReleaseDTO() {
		super();

	}
	public ReleaseDTO(int id, long member_id, String release_date, String status, int item_cnt, int company_id) {
		super();
		this.id = id;
//		this.client_id = client_id;
		this.member_id = member_id;
		this.release_date = release_date;
		this.status = status;
		this.item_cnt = item_cnt;
		this.company_id = company_id;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getClient_id() {
//		return client_id;
//	}
//	public void setClient_id(int client_id) {
//		this.client_id = client_id;
//	}
	public long getMember_id() {
		return member_id;
	}
	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getItem_cnt() {
		return item_cnt;
	}
	public void setItem_cnt(int item_cnt) {
		this.item_cnt = item_cnt;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	@Override
	public String toString() {
		return "ReleaseDTO [id=" + id + ", member_id=" + member_id + ", release_date=" + release_date + ", status="
				+ status + ", item_cnt=" + item_cnt + ", company_id=" + company_id + "]";
	}
	
	
}
