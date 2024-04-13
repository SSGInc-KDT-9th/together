package main.com.product.request;

public class ProductCreate {
    private Long categoryId;
    private Long supplierId;
    private String supplierName;
    private String productName;

    public ProductCreate(Long categoryId, Long supplierId, String supplierName, String productName) {
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.productName = productName;
    }

    public static ProductCreateBuilder builder() {
        return new ProductCreateBuilder();
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public Long getSupplierId() {
        return this.supplierId;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String toString() {
        Long var10000 = this.getCategoryId();
        return "ProductCreate(categoryId=" + var10000 + ", supplierId=" + this.getSupplierId() + ", supplierName=" + this.getSupplierName() + ", productName=" + this.getProductName() + ")";
    }

    public static class ProductCreateBuilder {
        private Long categoryId;
        private Long supplierId;
        private String supplierName;
        private String productName;

        ProductCreateBuilder() {
        }

        public ProductCreateBuilder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductCreateBuilder supplierId(Long supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public ProductCreateBuilder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public ProductCreateBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductCreate build() {
            return new ProductCreate(this.categoryId, this.supplierId, this.supplierName, this.productName);
        }

        public String toString() {
            return "ProductCreate.ProductCreateBuilder(categoryId=" + this.categoryId + ", supplierId=" + this.supplierId + ", supplierName=" + this.supplierName + ", productName=" + this.productName + ")";
        }
    }
}
