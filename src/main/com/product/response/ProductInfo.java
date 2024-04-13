package main.com.product.response;

public class ProductInfo {
    private Long id;
    private String productName;
    private Long categoryId;
    private String categoryName;
    private Long supplierId;
    private String supplierName;
    private final Integer inventory;
    private final Integer storePrice;
    private final Integer sellingPrice;

    public ProductInfo(String productName, Long categoryId, String categoryName, Long supplierId, String supplierName, Integer inventory, Integer storePrice, Integer sellingPrice) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.inventory = inventory;
        this.storePrice = storePrice;
        this.sellingPrice = sellingPrice;
    }

    public static ProductInfoBuilder builder() {
        return new ProductInfoBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getProductName() {
        return this.productName;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Long getSupplierId() {
        return this.supplierId;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public Integer getInventory() {
        return this.inventory;
    }

    public Integer getStorePrice() {
        return this.storePrice;
    }

    public Integer getSellingPrice() {
        return this.sellingPrice;
    }

    public ProductInfo(Integer inventory, Integer storePrice, Integer sellingPrice) {
        this.inventory = inventory;
        this.storePrice = storePrice;
        this.sellingPrice = sellingPrice;
    }

    public static class ProductInfoBuilder {
        private String productName;
        private Long categoryId;
        private String categoryName;
        private Long supplierId;
        private String supplierName;
        private Integer inventory;
        private Integer storePrice;
        private Integer sellingPrice;

        ProductInfoBuilder() {
        }

        public ProductInfoBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductInfoBuilder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductInfoBuilder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public ProductInfoBuilder supplierId(Long supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public ProductInfoBuilder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public ProductInfoBuilder inventory(Integer inventory) {
            this.inventory = inventory;
            return this;
        }

        public ProductInfoBuilder storePrice(Integer storePrice) {
            this.storePrice = storePrice;
            return this;
        }

        public ProductInfoBuilder sellingPrice(Integer sellingPrice) {
            this.sellingPrice = sellingPrice;
            return this;
        }

        public ProductInfo build() {
            return new ProductInfo(this.productName, this.categoryId, this.categoryName, this.supplierId, this.supplierName, this.inventory, this.storePrice, this.sellingPrice);
        }

        public String toString() {
            return "ProductInfo.ProductInfoBuilder(productName=" + this.productName + ", categoryId=" + this.categoryId + ", categoryName=" + this.categoryName + ", supplierId=" + this.supplierId + ", supplierName=" + this.supplierName + ", inventory=" + this.inventory + ", storePrice=" + this.storePrice + ", sellingPrice=" + this.sellingPrice + ")";
        }
    }
}
