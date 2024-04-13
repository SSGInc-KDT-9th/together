package main.com.release.dto;

public class ReleaseDTO {
	int id;
//	int client_id;
	int member_id;
	String release_date;
	String status;
	int item_cnt;
	public ReleaseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReleaseDTO(int id, int member_id, String release_date, String status, int item_cnt) {
		super();
		this.id = id;
//		this.client_id = client_id;
		this.member_id = member_id;
		this.release_date = release_date;
		this.status = status;
		this.item_cnt = item_cnt;
	}
	public int getId() {
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
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
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
	@Override
	public String toString() {
		return "releaseDTO [id=" + id + ", member_id=" + member_id + ", release_date="
				+ release_date + ", status=" + status + ", item_cnt=" + item_cnt + "]";
	}
	
}
