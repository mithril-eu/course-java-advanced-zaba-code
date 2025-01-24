package eu.mithril.invoice_service_boot.service;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import eu.mithril.invoice_service_boot.model.Invoice;
import eu.mithril.invoice_service_boot.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class InvoiceService {

    private final UserService userService;
    private final JdbcTemplate jdbcTemplate;
    private final String pdfUrl;

    public InvoiceService(
            UserService userService,
            JdbcTemplate jdbcTemplate,
            @Value("${app.url}") String appUrl) {
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
        this.pdfUrl = appUrl;
    }

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
    }

    public List<Invoice> findAll() {
        return jdbcTemplate.query(
                "select id, user_id, pdf_url, amount from invoices",
                (rs, rowNum) -> new Invoice(
                        rs.getObject("id").toString(),
                        rs.getString("user_id"),
                        rs.getInt("amount"),
                        rs.getString("pdf_url")
                )
        );
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        String insertSql = """
                INSERT INTO invoices (user_id, amount, pdf_url) 
                    VALUES (?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, userId);
            ps.setInt(2, amount);
            ps.setString(3, pdfUrl);
            return ps;
        }, keyHolder);

        String uuid = !keyHolder.getKeys().isEmpty() ? keyHolder.getKeys().values().iterator().next().toString() : null;
        Invoice invoice = new Invoice(uuid, userId, amount, pdfUrl);
        return invoice;
    }
}

