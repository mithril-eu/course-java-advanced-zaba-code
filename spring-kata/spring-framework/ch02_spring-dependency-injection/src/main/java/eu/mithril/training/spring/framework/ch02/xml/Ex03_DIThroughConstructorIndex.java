package eu.mithril.training.spring.framework.ch02.xml;

import eu.mithril.training.spring.framework.ch02.model.ColoredShapeHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex03_DIThroughConstructorIndex {

    public static void main(String args[]) {

        // XML based config loading
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "ex03-di-through-constructor-index.xml");

        ColoredShapeHolder coloredShapeHolder =
                (ColoredShapeHolder) context.getBean("coloredShapeHolder");

        System.out.println(coloredShapeHolder.toString());
    }
}