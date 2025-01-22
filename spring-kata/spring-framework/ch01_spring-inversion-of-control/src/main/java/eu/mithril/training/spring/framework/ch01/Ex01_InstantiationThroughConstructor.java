package eu.mithril.training.spring.framework.ch01;

import eu.mithril.training.spring.framework.ch01.model.ColoredShape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01_InstantiationThroughConstructor {
    public static void main(String args[]) {

        // XML based config loading
        ApplicationContext context = new ClassPathXmlApplicationContext("ex01-instantiation-through-constructor.xml");

        ColoredShape coloredShapeBean = (ColoredShape) context.getBean("coloredShapeBean");

        System.out.println(coloredShapeBean.toString());
    }
}