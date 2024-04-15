package main.com.product.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Stock {
    private Long id;
    private Long productId;
    private LocalDateTime modifiedDate;
    private Integer inventory;
    private Integer storePrice;
    private Integer sellingPrice;

    public Stock(Long id,Long productId, LocalDateTime modifiedDate, Integer inventory, Integer storePrice, Integer sellingPrice) {
        this.id = id;
        this.productId = productId;
        this.modifiedDate = modifiedDate;
        this.inventory = inventory;
        this.storePrice = storePrice;
        this.sellingPrice = sellingPrice;
    }

    public StockEdit.StockEditBuilder toEditor(){
        return StockEdit.builder()
                .productId(this.productId)
                .modifiedDate(this.modifiedDate)
                .inventory(this.inventory)
                .storePrice(this.storePrice)
                .sellingPrice(this.sellingPrice);
    }

    public void edit(StockEdit editor){
        this.productId = editor.getProductId();
        this.modifiedDate = editor.getModifiedDate();
        this.inventory = editor.getInventory();
        this.storePrice = editor.getStorePrice();
        this.sellingPrice = editor.getSellingPrice();
    }

    public static StockBuilder builder() {
        return new StockBuilder();
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public Integer getInventory() {
        return inventory;
    }

    public Integer getStorePrice() {
        return storePrice;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public static class StockBuilder {
        private Long id;
        private Long productId;
        private LocalDateTime modifiedDate;
        private Integer inventory;
        private Integer storePrice;
        private Integer sellingPrice;

        StockBuilder() {
        }

        public StockBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public StockBuilder productId(final Long productId) {
            this.productId = productId;
            return this;
        }

        public StockBuilder modifiedDate(final LocalDateTime modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public StockBuilder inventory(final Integer inventory) {
            this.inventory = inventory;
            return this;
        }

        public StockBuilder storePrice(final Integer storePrice) {
            this.storePrice = storePrice;
            return this;
        }

        public StockBuilder sellingPrice(final Integer sellingPrice) {
            this.sellingPrice = sellingPrice;
            return this;
        }

        public Stock build() {
            return new Stock(this.id,this.productId, this.modifiedDate, this.inventory, this.storePrice, this.sellingPrice);
        }

        public String toString() {
            return "Stock.StockBuilder(productId=" + this.productId + ", modifiedDate=" + this.modifiedDate + ", inventory=" + this.inventory + ", storePrice=" + this.storePrice + ", sellingPrice=" + this.sellingPrice + ")";
        }
    }
}
