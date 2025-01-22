package eu.mithril.invoice.web;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.mithril.invoice.context.ApplicationConfiguration;
import eu.mithril.invoice.model.Invoice;
import eu.mithril.invoice.service.InvoiceService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InvoiceServlet extends HttpServlet {

    private ObjectMapper objectMapper;
    private InvoiceService invoiceService;

    @Override
    public void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ApplicationConfiguration.class
        );
        this.objectMapper = context.getBean(ObjectMapper.class);
        this.invoiceService = context.getBean(InvoiceService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/")) {
            resp.setContentType("text/html; charset=UTF-8");
            String html = """
                    <html>
                    <body>
                    <h1>Hello World</h1>
                    <p>My first Servlet</p>
                    </body>
                    </html>
                    """;
            resp.getWriter().println(html);
        } else if (req.getRequestURI().equals("/invoices")) {
            resp.setContentType("application/json; charset=UTF-8");
            List<Invoice> invoices = invoiceService.findAll();
            String json = objectMapper.writeValueAsString(invoices);
            resp.getWriter().println(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/invoices")) {
            String userId = req.getParameter("user_id");
            Integer amount = Integer.valueOf(req.getParameter("amount"));
            Invoice invoice = invoiceService.create(userId, amount);
            String json = objectMapper.writeValueAsString(invoice);
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print(json);
        }
    }
}