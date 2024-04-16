package main.com.sales.request;

public class SalesSearch {
    private Long ClientId;
    private Long productId;
    private String productName;
    private String startDate;
    private String endDate;

    public SalesSearch(Long clientId, Long productId, String productName, String startDate, String endDate) {
        this.ClientId = clientId;
        this.productId = productId;
        this.productName = productName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static SalesSearchBuilder builder() {
        return new SalesSearchBuilder();
    }

    public Long getClientId() {
        return this.ClientId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public static class SalesSearchBuilder {
        private Long clientId;
        private Long productId;
        private String productName;
        private String startDate;
        private String endDate;

        SalesSearchBuilder() {
        }

        public SalesSearchBuilder clientId(final Long clientId) {
            this.clientId = clientId;
            return this;
        }

        public SalesSearchBuilder productId(final Long productId) {
            this.productId = productId;
            return this;
        }

        public SalesSearchBuilder productName(final String productName) {
            this.productName = productName;
            return this;
        }

        public SalesSearchBuilder startDate(final String startDate) {
            this.startDate = startDate;
            return this;
        }

        public SalesSearchBuilder endDate(final String endDate) {
            this.endDate = endDate;
            return this;
        }

        public SalesSearch build() {
            return new SalesSearch(this.clientId, this.productId, this.productName, this.startDate, this.endDate);
        }

        public String toString() {
            return "SalesSearch.SalesSearchBuilder(clientId=" + this.clientId + ", productId=" + this.productId + ", productName=" + this.productName + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ")";
        }
    }
}
