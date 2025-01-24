package eu.mithril.invoice_service_boot.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import eu.mithril.invoice_service_boot.model.Invoice;
import eu.mithril.invoice_service_boot.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class InvoiceService {

    private List<Invoice> invoices = new CopyOnWriteArrayList<>();

    private final UserService userService;
    private final String pdfUrl;

    public InvoiceService(
            UserService userService,
            @Value("${app.url}") String appUrl) {
        this.userService = userService;
        this.pdfUrl = appUrl;
    }

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        Invoice invoice = new Invoice(userId, amount, pdfUrl);
        invoices.add(invoice);
        return invoice;
    }
}

