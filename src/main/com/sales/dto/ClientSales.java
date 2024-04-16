package main.com.sales.dto;

public class ClientSales {
    private Long clientId;
    private Integer totalPrice;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ClientSales{" +
                "clientId=" + clientId +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
