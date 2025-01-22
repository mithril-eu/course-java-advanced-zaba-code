package eu.mithril.training.spring.framework.ch02.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.mithril.training.spring.framework.ch02.model.ConstructorAnnotatedColoredShapeHolder;

public class Ex06_DIThroughAnnotationConstructor {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ex06-di-through-annotation-constructor.xml");

        ConstructorAnnotatedColoredShapeHolder constructorAnnotatedColoredShapeHolder =
                (ConstructorAnnotatedColoredShapeHolder) context.getBean("constructorAnnotatedColoredShapeHolder");

        System.out.println(constructorAnnotatedColoredShapeHolder);
    }
}
