package main.com.product.request;

public class ProductSearch {
    private Long id;
    private String productName;
    private String supplierName;
    private String categoryName;

    public ProductSearch(Long id, String productName, String supplierName, String categoryName) {
        this.id = id;
        this.productName = productName;
        this.supplierName = supplierName;
        this.categoryName = categoryName;
    }

    public static ProductSearchBuilder builder() {
        return new ProductSearchBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public static class ProductSearchBuilder {
        private Long id;
        private String productName;
        private String supplierName;
        private String categoryName;

        ProductSearchBuilder() {
        }

        public ProductSearchBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductSearchBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductSearchBuilder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public ProductSearchBuilder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public ProductSearch build() {
            return new ProductSearch(this.id, this.productName, this.supplierName, this.categoryName);
        }

        public String toString() {
            return "ProductSearch.ProductSearchBuilder(id=" + this.id + ", productName=" + this.productName + ", supplierName=" + this.supplierName + ", categoryName=" + this.categoryName + ")";
        }
    }
}
