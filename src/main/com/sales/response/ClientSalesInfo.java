package main.com.sales.response;

public class ClientSalesInfo {
    private Long clientId;
    private String clientName;
    private String clientCategory;
    private Integer totalPrice;

    public ClientSalesInfo(Long clientId, String clientName, String clientCategory, Integer totalPrice) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientCategory = clientCategory;
        this.totalPrice = totalPrice;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCategory() {
        return clientCategory;
    }

    public void setClientCategory(String clientCategory) {
        this.clientCategory = clientCategory;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
