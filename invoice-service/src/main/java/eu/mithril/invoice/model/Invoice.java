package eu.mithril.invoice.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice {

    String id;
    @JsonProperty("user_id")
    String userId;
    Integer amount;
    @JsonProperty("pdf_url")
    String pdfUrl;

    public Invoice() {
    }

    public Invoice(String userId, Integer amount, String pdfUrl) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.amount = amount;
        this.pdfUrl = pdfUrl;
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
