package eu.mithril.training.spring.framework.ch02.xml;

import eu.mithril.training.spring.framework.ch02.model.ColoredShapeHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex04_DIThroughSetters {

    public static void main(String args[]) {

        // XML based config loading
        ApplicationContext context = new ClassPathXmlApplicationContext("ex04-di-through-setters.xml");

        ColoredShapeHolder coloredShapeHolder = (ColoredShapeHolder) context.getBean("coloredShapeHolder");

        System.out.println(coloredShapeHolder.toString());
    }

}
