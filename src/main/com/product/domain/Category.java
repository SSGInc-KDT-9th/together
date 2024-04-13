package main.com.product.domain;

public class Category {
    private Long categoryId;
    private String categoryName;
    private Long parentCategoryId;

    public Category(Long categoryId, String categoryName, Long parentCategoryId) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentCategoryId = parentCategoryId;
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Long getParentCategoryId() {
        return this.parentCategoryId;
    }

    public Category() {
    }

    public static class CategoryBuilder {
        private Long categoryId;
        private String categoryName;
        private Long parentCategoryId;

        CategoryBuilder() {
        }

        public CategoryBuilder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public CategoryBuilder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public CategoryBuilder parentCategoryId(Long parentCategoryId) {
            this.parentCategoryId = parentCategoryId;
            return this;
        }

        public Category build() {
            return new Category(this.categoryId, this.categoryName, this.parentCategoryId);
        }

        public String toString() {
            return "Category.CategoryBuilder(categoryId=" + this.categoryId + ", categoryName=" + this.categoryName + ", parentCategoryId=" + this.parentCategoryId + ")";
        }
    }
}
