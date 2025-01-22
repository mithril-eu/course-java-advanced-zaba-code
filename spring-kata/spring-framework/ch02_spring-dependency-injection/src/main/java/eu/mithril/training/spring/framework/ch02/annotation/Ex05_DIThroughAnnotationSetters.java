package eu.mithril.training.spring.framework.ch02.annotation;

import eu.mithril.training.spring.framework.ch02.model.SetterAnnotatedColoredShapeHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex05_DIThroughAnnotationSetters {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ex05-di-through-annotation-setters.xml");

        SetterAnnotatedColoredShapeHolder setterAnnotatedColoredShapeHolder =
                (SetterAnnotatedColoredShapeHolder) context.getBean("setterAnnotatedColoredShapeHolder");

        System.out.println(setterAnnotatedColoredShapeHolder);
    }
}
