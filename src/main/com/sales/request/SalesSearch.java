package main.com.sales.request;

public class SalesSearch {
    private Long clientId;
    private String clientName;
    private Long productId;
    private String productName;
    private String startDate;
    private String endDate;

    public SalesSearch(Long clientId, String clientName, Long productId, String productName, String startDate, String endDate) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.productId = productId;
        this.productName = productName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static SalesSearchBuilder builder() {
        return new SalesSearchBuilder();
    }

    public Long getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
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
        private String clientName;
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

        public SalesSearchBuilder clientName(final String clientName) {
            this.clientName = clientName;
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
            return new SalesSearch(this.clientId, this.clientName, this.productId, this.productName, this.startDate, this.endDate);
        }

        public String toString() {
            return "SalesSearch.SalesSearchBuilder(clientId=" + this.clientId + ", clientName=" + this.clientName + ", productId=" + this.productId + ", productName=" + this.productName + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ")";
        }
    }
}
