package eu.mithril.invoice.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.mithril.invoice.service.InvoiceService;
import eu.mithril.invoice.service.UserService;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public InvoiceService invoiceService(UserService userService) {
        return new InvoiceService(userService);
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
