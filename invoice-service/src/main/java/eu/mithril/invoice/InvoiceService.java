package eu.mithril.invoice;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
