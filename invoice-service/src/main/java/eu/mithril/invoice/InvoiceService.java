package eu.mithril.invoice;

public class InvoiceService {

    public Invoice create(String userId, Integer amount) {
        return new Invoice(userId, amount, "https://pdfobject.com/pdf/sample.pdf");
    }

}
