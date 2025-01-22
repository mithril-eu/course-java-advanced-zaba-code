package eu.mithril.training.spring.framework.ch05.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"eu.mithril.training.spring.framework.ch05"})
public class ColoredShapeConfig {
}