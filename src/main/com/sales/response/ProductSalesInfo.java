package main.com.sales.response;

public class ProductSalesInfo {
    private Long productId;
    private String productName;
    private String productCategory;
    private Integer totalPrice;

    public ProductSalesInfo(Long productId, String productName, String productCategory, Integer totalPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.totalPrice = totalPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
