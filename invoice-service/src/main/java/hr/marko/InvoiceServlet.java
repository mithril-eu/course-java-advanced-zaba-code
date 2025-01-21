package hr.marko;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InvoiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/")) {
            resp.setContentType("text/html; charset=UTF-8");
            String html = """
                    <html>
                        <body>
                        <h1>Hello World!</h1>
                    <p> This is my first servlet.</p>
                    </html>
                    """;
            resp.getWriter().println(html);

        } else if (req.getRequestURI().equals("/invoices")) {
            String userId = req.getParameter("user_id");
            Integer amount = Integer.valueOf(req.getParameter("amount"));

            Invoice invoice = new InvoiceService().createInvoice(userId, amount);
            resp.setContentType("application/json; charset=UTF-8");
            String jsonResponse = new ObjectMapper().writeValueAsString(invoice);
            resp.getWriter().println(jsonResponse);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }

}
