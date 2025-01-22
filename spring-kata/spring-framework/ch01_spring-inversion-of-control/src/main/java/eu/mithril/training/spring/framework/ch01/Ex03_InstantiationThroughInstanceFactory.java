package eu.mithril.training.spring.framework.ch01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.mithril.training.spring.framework.ch01.model.ColoredShape;

public class Ex03_InstantiationThroughInstanceFactory {

    public Ex03_InstantiationThroughInstanceFactory() {
        System.out.println("Ex03_InstantiationThroughInstanceFactory is now loaded.");
    }

    // This is an instance method. The class is first loaded as is visible
    // from the printed statement of the default constructor.
    public ColoredShape getInstance() {
        return new ColoredShape("red", "rhombus");
    }

    public static void main(String[] args) {

        // XML based config loading
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "ex03-instantiation-through-instance-factory.xml"
        );

        ColoredShape coloredShapeBean = (ColoredShape) context.getBean("coloredShapeBean");

        System.out.println(coloredShapeBean.toString());
    }
}