package eu.mithril.invoice.service;

import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("dev")
public class DummyInvoiceServiceLoader {

    private final InvoiceService invoiceService;

    public DummyInvoiceServiceLoader(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostConstruct
    public void load() {
        System.out.println("creating dummy invoices...");
        invoiceService.create(UUID.randomUUID().toString(), 100);
        invoiceService.create(UUID.randomUUID().toString(), 200);
        invoiceService.create(UUID.randomUUID().toString(), 300);
    }

}
