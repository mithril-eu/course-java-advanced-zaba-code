package eu.mithril.invoice.service;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import eu.mithril.invoice.model.Invoice;
import eu.mithril.invoice.model.User;
import jakarta.annotation.PostConstruct;

@Component
public class InvoiceService {

    private UserService userService;
    private String pdfUrl;
    private JdbcTemplate jdbcTemplate;

    public InvoiceService(
            UserService userService,
            JdbcTemplate jdbcTemplate,
            @Value("${app.url}") String url) {
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
        this.pdfUrl = url;
    }

    public UserService getUserService() {
        return userService;
    }

    @Transactional
    public List<Invoice> findAll() {
        System.out.println("transaction open =" + TransactionSynchronizationManager.isActualTransactionActive());
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

    @Transactional
    public Invoice create(String userId, Integer amount) {
        System.out.println("transaction open =" + TransactionSynchronizationManager.isActualTransactionActive());

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

    @PostConstruct
    public void postContruct() {
        System.out.println("Post contruct invoice service");
    }

}
