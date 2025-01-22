package eu.mithril.training.spring.boot.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("default")
public class TodoDefaultServiceSwaggerConfig {

    final ProfileConfigurationProperties profileConfigurationProperties;

    public TodoDefaultServiceSwaggerConfig(ProfileConfigurationProperties profileConfigurationProperties) {
        this.profileConfigurationProperties = profileConfigurationProperties;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("todo")
                .select()
                .apis(RequestHandlerSelectors.basePackage("eu.mithril.training.spring.boot.todo"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(profileConfigurationProperties.getTitle())
                .description("A " + profileConfigurationProperties.getDescriptiveText() +
                        " profile demo application showing how to setup a Spring Boot application")
                .termsOfServiceUrl("https://opensource.org/license/mit")
                .license("License")
                .licenseUrl("https://opensource.org/license/mit")
                .version("1.0")
                .build();
    }

}
