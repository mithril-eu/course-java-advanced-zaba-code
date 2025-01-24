package eu.mithril.invoice_service_boot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import eu.mithril.invoice_service_boot.model.Invoice;
import eu.mithril.invoice_service_boot.model.User;
import eu.mithril.invoice_service_boot.repository.InvoiceRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceTest {

    @Mock
    private UserService userService;
    @Mock
    private InvoiceRepository invoiceRepository;
    private String pdfUrl = "some-url";

    @InjectMocks
    private InvoiceService underTest;

    private static final String USER_ID = "user-id";
    private static final String USER_NAME = "user-name";
    private static final User USER = new User(USER_ID, USER_NAME);

    @Test
    void createInvoice_() {
        // given
        var testInvoice = new Invoice("user-id", 100, "some-url");
        when(userService.findById(USER_ID)).thenReturn(USER);
        when(invoiceRepository.save(any(Invoice.class))).thenReturn(testInvoice);

        // when
        Invoice invoice = underTest.create("user-id", 100);

        // then
        assertNotNull(invoice);
        assertEquals(testInvoice.getAmount(), 100);

        verify(userService).findById(USER_ID);
        verify(invoiceRepository).save(any(Invoice.class));
    }



}