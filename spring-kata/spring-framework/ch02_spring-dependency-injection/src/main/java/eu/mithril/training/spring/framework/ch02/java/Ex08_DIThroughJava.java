package eu.mithril.training.spring.framework.ch02.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import eu.mithril.training.spring.framework.ch02.model.AutowiredColoredShapeHolder;

@ComponentScan(basePackages = {"eu.mithril.training.spring.framework.ch02.model"})
public class Ex08_DIThroughJava {

    @Autowired
    private AutowiredColoredShapeHolder autowiredColoredShapeHolder;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(Ex08_DIThroughJava.class);
        annotationConfigApplicationContext.refresh();

        AutowiredColoredShapeHolder autowiredColoredShapeHolder = annotationConfigApplicationContext.getBean
                (AutowiredColoredShapeHolder.class);
        System.out.println(autowiredColoredShapeHolder);
    }

}
