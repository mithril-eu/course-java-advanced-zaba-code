package eu.mithril.invoice.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import eu.mithril.invoice.model.Invoice;
import eu.mithril.invoice.model.User;

public class InvoiceService {

    private final UserService userService;

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public InvoiceService(UserService userService) {
        this.userService = userService;
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Invoice invoice = new Invoice(userId, amount, "https://pdfobject.com/pdf/sample.pdf");
        invoices.add(invoice);
        return invoice;

    }

}
