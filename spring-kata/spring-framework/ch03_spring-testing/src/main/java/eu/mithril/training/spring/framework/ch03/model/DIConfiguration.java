package eu.mithril.training.spring.framework.ch03.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//ComponentScan is optional and only required if there are other components that depend on, or are depended on this configuration.
@ComponentScan(basePackages = {"eu.mithril.training.spring.framework.ch03"})
public class DIConfiguration {

    @Bean(name = "tealTrapezoid")
    public ColoredShape myColoredShape() {
        return new ColoredShape("teal", "trapezoid");
    }

    @Bean("tealTrapezoidHolder")
    @Qualifier("tealTrapezoidHolder")
    public ColoredShapeHolder myColoredShapeHolder() {
        return new ColoredShapeHolder(myColoredShape(), 10);
    }


    @Bean("pinkPolygonHolder")
    @Qualifier("pinkPolygonHolder")
    public ColoredShapeHolder mySecondColoredShapeHolder() {
        return new ColoredShapeHolder(new ColoredShape("pink", "polygon"), 7);
    }

}
