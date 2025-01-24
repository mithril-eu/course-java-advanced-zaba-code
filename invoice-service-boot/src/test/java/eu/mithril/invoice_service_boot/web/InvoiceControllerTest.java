package eu.mithril.invoice_service_boot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;

import eu.mithril.invoice_service_boot.model.Invoice;
import eu.mithril.invoice_service_boot.repository.InvoiceRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InvoiceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    public void findAllInvoices() {
        // given
        var testInvoice = new Invoice("user-id", 100, "some-url");
        invoiceRepository.save(testInvoice);

        // when
        var invoices = restTemplate.getForObject("/invoices", Invoice[].class);

        // then
        assert invoices.length == 1;
    }


}