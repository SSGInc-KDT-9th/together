package main.com.product.domain;

public class Category {
    private Long id;
    private String categoryName;
    private Long parentCategoryId;

    public Category(Long id, String categoryName, Long parentCategoryId) {
        this.id = id;
        this.categoryName = categoryName;
        this.parentCategoryId = parentCategoryId;
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public Long getCategoryId() {
        return this.id;
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
        private Long id;
        private String categoryName;
        private Long parentCategoryId;

        CategoryBuilder() {
        }

        public CategoryBuilder id(Long id) {
            this.id = id;
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
            return new Category(this.id, this.categoryName, this.parentCategoryId);
        }

        public String toString() {
            return "Category.CategoryBuilder(categoryId=" + this.id + ", categoryName=" + this.categoryName + ", parentCategoryId=" + this.parentCategoryId + ")";
        }
    }
}
