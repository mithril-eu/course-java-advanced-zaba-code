package eu.mithril.invoice.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.mithril.invoice.ApplicationLauncher;

@PropertySource("classpath:/application.properties")
@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
public class ApplicationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
