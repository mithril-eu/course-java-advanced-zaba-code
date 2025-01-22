package eu.mithril.training.spring.framework.ch02.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import eu.mithril.training.spring.framework.ch02.model.ColoredShapeHolder;
import eu.mithril.training.spring.framework.ch02.model.DIConfiguration;

@ComponentScan(basePackages = {"eu.mithril.training.spring.framework.ch02.model"})
public class Ex09_DIThroughJavaConfiguration {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(DIConfiguration.class);

        ColoredShapeHolder tealTrapezoidHolder = (ColoredShapeHolder) annotationConfigApplicationContext.getBean("tealTrapezoidHolder");

        System.out.println(tealTrapezoidHolder);
    }
}
