package eu.mithril.invoice_service_boot.web;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.mithril.invoice_service_boot.model.Invoice;
import eu.mithril.invoice_service_boot.model.dto.InvoiceDto;
import eu.mithril.invoice_service_boot.service.InvoiceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Validated
@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public Iterable<Invoice> invoices() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }

    @PostMapping("/invoices-params")
    public Invoice createInvoice(
            @RequestParam("user_id") @NotBlank String userId,
            @RequestParam("amount") @Min(15) @Max(100) Integer amount
    ) {
        return invoiceService.create(userId, amount);
    }

    @GetMapping("/invoices/user/{userId}")
    public Iterable<Invoice> findByUserId(@PathVariable String userId) {
        return invoiceService.findByUser(userId);
    }

}
