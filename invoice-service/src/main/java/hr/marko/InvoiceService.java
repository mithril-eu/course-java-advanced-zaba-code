package hr.marko;

public class InvoiceService {

    public Invoice createInvoice(String userId, Integer amount) {
        String dummyPdf = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
        return new Invoice(userId, amount, dummyPdf);
    }
}
