package eu.mithril.invoice.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import eu.mithril.invoice.model.Invoice;
import eu.mithril.invoice.model.User;
import jakarta.annotation.PostConstruct;

@Component
public class InvoiceService {

    private UserService userService;
    private String pdfUrl;

    public InvoiceService(UserService userService, @Value("${app.url}") String url) {
        this.userService = userService;
        this.pdfUrl = url;
    }

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public UserService getUserService() {
        return userService;
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Invoice invoice = new Invoice(userId, amount, pdfUrl);
        invoices.add(invoice);
        return invoice;

    }

    @PostConstruct
    public void postContruct() {
        System.out.println("Post contruct invoice service");
    }

}
