package eu.mithril.invoice.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.mithril.invoice.service.InvoiceService;
import eu.mithril.invoice.service.UserService;

public class Application {

    public static final UserService USER_SERVICE = new UserService();
    public static final InvoiceService INVOICE_SERVICE = new InvoiceService(USER_SERVICE);
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

}
