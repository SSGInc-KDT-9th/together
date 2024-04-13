package main.com.product.domain;

public class Product {
    private Long id;
    private Long categoryId;
    private Long supplierId;
    private String supplierName;
    private String productName;

    public Product(Long categoryId, Long supplierId, String supplierName, String productName) {
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.productName = productName;
    }

    public ProductEdit.ProductEditBuilder toEditor() {
        return ProductEdit.builder().categoryId(this.categoryId).supplierId(this.supplierId).supplierName(this.supplierName).productName(this.productName);
    }

    public void edit(ProductEdit editor) {
        this.categoryId = editor.getCategoryId();
        this.supplierId = editor.getSupplierId();
        this.productName = editor.getProductName();
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public Long getId() {
        return this.id;
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

    public String toString() {
        Long var10000 = this.getId();
        return "Product(id=" + var10000 + ", categoryId=" + this.getCategoryId() + ", supplierId=" + this.getSupplierId() + ", supplierName=" + this.getSupplierName() + ", productName=" + this.getProductName() + ")";
    }

    public static class ProductBuilder {
        private Long categoryId;
        private Long supplierId;
        private String supplierName;
        private String productName;

        ProductBuilder() {
        }

        public ProductBuilder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductBuilder supplierId(Long supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public ProductBuilder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public ProductBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Product build() {
            return new Product(this.categoryId, this.supplierId, this.supplierName, this.productName);
        }

        public String toString() {
            return "Product.ProductBuilder(categoryId=" + this.categoryId + ", supplierId=" + this.supplierId + ", supplierName=" + this.supplierName + ", productName=" + this.productName + ")";
        }
    }
}
