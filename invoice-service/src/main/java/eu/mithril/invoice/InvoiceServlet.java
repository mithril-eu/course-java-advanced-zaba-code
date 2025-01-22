package eu.mithril.invoice;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/invoice")) {
            String userId = req.getParameter("user_id");
            Integer amount = Integer.valueOf(req.getParameter("amount"));

            Invoice invoice = new InvoiceService().create(userId, amount);
            String json = new ObjectMapper().writeValueAsString(invoice);
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print(json);
        }
    }
}