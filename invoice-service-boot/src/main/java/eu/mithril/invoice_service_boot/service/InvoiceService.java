package eu.mithril.invoice_service_boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eu.mithril.invoice_service_boot.model.Invoice;
import eu.mithril.invoice_service_boot.model.User;
import eu.mithril.invoice_service_boot.repository.InvoiceRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class InvoiceService {

    private final UserService userService;
    private final JdbcTemplate jdbcTemplate;
    private final String pdfUrl;
    private final InvoiceRepository invoiceRepository;


    public InvoiceService(
            UserService userService,
            JdbcTemplate jdbcTemplate,
            @Value("${app.url}") String appUrl,
            InvoiceRepository invoiceRepository
    ) {
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
        this.pdfUrl = appUrl;
        this.invoiceRepository = invoiceRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
    }

    @Transactional
    public Iterable<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        Invoice invoice = new Invoice(userId, amount, pdfUrl);
        return invoiceRepository.save(invoice);
    }

}

