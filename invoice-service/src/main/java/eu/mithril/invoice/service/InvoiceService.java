package eu.mithril.invoice.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import eu.mithril.invoice.model.Invoice;

public class InvoiceService {

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        Invoice invoice = new Invoice(userId, amount, "https://pdfobject.com/pdf/sample.pdf");
        invoices.add(invoice);
        return invoice;

    }

}
