package main.com.product.domain;//

import java.time.LocalDateTime;

public class StockEdit {
    private Long productId;
    private LocalDateTime modifiedDate;
    private Integer inventory;
    private Integer storePrice;
    private Integer sellingPrice;

    public StockEdit(Long productId, LocalDateTime modifiedDate, Integer inventory, Integer storePrice, Integer sellingPrice) {
        this.productId = productId;
        this.modifiedDate = modifiedDate;
        this.inventory = inventory;
        this.storePrice = storePrice;
        this.sellingPrice = sellingPrice;
    }

    public static StockEditBuilder builder() {
        return new StockEditBuilder();
    }

    public Long getProductId() {
        return this.productId;
    }

    public LocalDateTime getModifiedDate() {
        return this.modifiedDate;
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

    public static class StockEditBuilder {
        private Long productId;
        private LocalDateTime modifiedDate;
        private Integer inventory;
        private Integer storePrice;
        private Integer sellingPrice;

        StockEditBuilder() {
        }

        public StockEditBuilder productId(final Long productId) {
            this.productId = productId;
            return this;
        }

        public StockEditBuilder modifiedDate(final LocalDateTime modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public StockEditBuilder inventory(final Integer inventory) {
            this.inventory = inventory;
            return this;
        }

        public StockEditBuilder storePrice(final Integer storePrice) {
            this.storePrice = storePrice;
            return this;
        }

        public StockEditBuilder sellingPrice(final Integer sellingPrice) {
            this.sellingPrice = sellingPrice;
            return this;
        }

        public StockEdit build() {
            return new StockEdit(this.productId, this.modifiedDate, this.inventory, this.storePrice, this.sellingPrice);
        }

        public String toString() {
            return "StockEdit.StockEditBuilder(productId=" + this.productId + ", modifiedDate=" + this.modifiedDate + ", inventory=" + this.inventory + ", storePrice=" + this.storePrice + ", sellingPrice=" + this.sellingPrice + ")";
        }
    }
}
