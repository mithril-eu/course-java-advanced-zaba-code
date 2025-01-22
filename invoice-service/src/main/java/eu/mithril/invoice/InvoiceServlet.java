package eu.mithril.invoice;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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