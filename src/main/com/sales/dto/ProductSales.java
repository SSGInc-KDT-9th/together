package main.com.sales.dto;

public class ProductSales {
    private Long productId;
    private Integer totalPrice;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalSales(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ProductSales{" +
                "productId=" + productId +
                ", totalSales=" + totalPrice +
                '}';
    }
}
