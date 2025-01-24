package eu.mithril.invoice_service_boot.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class InvoiceDto {

    @JsonProperty("user_id")
    @NotBlank
    private String userId;

    @Min(15)
    @Max(100)
    private Integer amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
