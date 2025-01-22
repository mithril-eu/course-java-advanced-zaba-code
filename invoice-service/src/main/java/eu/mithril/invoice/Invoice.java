package eu.mithril.invoice;

import java.util.UUID;

public class Invoice {

    String id;
    String userId;
    Integer amount;
    String pdfUrl;

    public Invoice() {
    }

    public Invoice(String userId, Integer amount) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.amount = amount;
        this.pdfUrl = "https://pdfobject.com/pdf/sample.pdf";
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }
}
