package eu.mithril.training.spring.framework.ch02.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfiguration {

    @Bean(name = "tealTrapezoid")
    public ColoredShape myColoredShape() {

        return new ColoredShape("teal", "trapezoid");
    }

    @Bean ("tealTrapezoidHolder")
    public ColoredShapeHolder myColoredShapeHolder() {

        return new ColoredShapeHolder(myColoredShape(), 10);
    }

    @Bean ("redRectangleHolder")
    public ColoredShapeHolder otherColoredShapeHolder() {

        return new ColoredShapeHolder(new RedRectangle(), 10);
    }
}