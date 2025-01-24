package eu.mithril.invoice_service_boot.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import eu.mithril.invoice_service_boot.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {

    @Query("""
            select id, pdf_url, amount, user_id
            from "invoices" where user_id = :userId           
            """)
    Iterable<Invoice> findByUserId(@Param("userId") String userId);



}
