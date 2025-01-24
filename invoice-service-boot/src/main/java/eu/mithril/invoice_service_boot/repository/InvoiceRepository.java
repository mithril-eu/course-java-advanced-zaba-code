package eu.mithril.invoice_service_boot.repository;

import org.springframework.data.repository.CrudRepository;

import eu.mithril.invoice_service_boot.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {

}
