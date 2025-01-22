package eu.mithril.invoice.web;

import java.io.IOException;
import java.util.List;

import eu.mithril.invoice.context.Application;
import eu.mithril.invoice.model.Invoice;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static eu.mithril.invoice.context.Application.INVOICE_SERVICE;

public class InvoiceServlet extends HttpServlet {

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
            List<Invoice> invoices = INVOICE_SERVICE.findAll();
            String json = Application.OBJECT_MAPPER.writeValueAsString(invoices);
            resp.getWriter().println(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/invoices")) {
            String userId = req.getParameter("user_id");
            Integer amount = Integer.valueOf(req.getParameter("amount"));
            Invoice invoice = INVOICE_SERVICE.create(userId, amount);
            String json = Application.OBJECT_MAPPER.writeValueAsString(invoice);
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print(json);
        }
    }
}