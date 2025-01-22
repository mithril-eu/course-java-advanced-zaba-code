package eu.mithril.training.spring.framework.ch01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.mithril.training.spring.framework.ch01.model.ColoredShape;

public class Ex02_InstantiationThroughStaticFactory {

    // This is a static method. The content of this method is used to
    // construct the ColoredShape. There can be many such methods that
    // return other configurations.
    public static ColoredShape getInstance() {
        return new ColoredShape("harlequin", "hexagon");
    }

    public static void main(String[] args) {

        // XML based config loading
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ex02-instantiation-through-static-factory.xml");

        ColoredShape coloredShapeBean = (ColoredShape) context.getBean("coloredShapeBean");

        System.out.println(coloredShapeBean);
    }

}