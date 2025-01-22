package eu.mithril.training.spring.framework.ch08.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"eu.mithril.training.spring.framework.ch08"})
public class ColoredShapeConfig {
}
