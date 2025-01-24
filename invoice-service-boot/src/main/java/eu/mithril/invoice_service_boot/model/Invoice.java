package eu.mithril.invoice_service_boot.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Table("invoices")
public class Invoice {

    @Id
    String id;
    @JsonProperty("user_id")
    String userId;
    Integer amount;
    @JsonProperty("pdf_url")
    String pdfUrl;

    public Invoice() {
    }

    public Invoice(String userId, Integer amount, String pdfUrl) {
        this.userId = userId;
        this.amount = amount;
        this.pdfUrl = pdfUrl;
    }

    public Invoice(String id, String userId, Integer amount, String pdfUrl) {
        this.id = id;
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

    public void setId(String id) {
        this.id = id;
    }
}
