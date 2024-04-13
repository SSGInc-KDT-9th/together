package main.com.product.domain;

public class ProductEdit {
    private final String productName;
    private final Long categoryId;
    private final Long supplierId;
    private final String supplierName;

    public ProductEdit(String productName, Long categoryId, Long supplierId, String supplierName) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public static ProductEditBuilder builder() {
        return new ProductEditBuilder();
    }

    public String getProductName() {
        return this.productName;
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

    public static class ProductEditBuilder {
        private String productName;
        private Long categoryId;
        private Long supplierId;
        private String supplierName;

        ProductEditBuilder() {
        }

        public ProductEditBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductEditBuilder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductEditBuilder supplierId(Long supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public ProductEditBuilder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public ProductEdit build() {
            return new ProductEdit(this.productName, this.categoryId, this.supplierId, this.supplierName);
        }

        public String toString() {
            return "ProductEdit.ProductEditBuilder(productName=" + this.productName + ", categoryId=" + this.categoryId + ", supplierId=" + this.supplierId + ", supplierName=" + this.supplierName + ")";
        }
    }
}
