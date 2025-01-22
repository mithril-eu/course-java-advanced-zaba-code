package eu.mithril.training.spring.framework.ch04;

import java.util.List;

import eu.mithril.training.spring.framework.ch04.dao.ColoredShapeDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import eu.mithril.training.spring.framework.ch04.model.ColoredShape;

@ComponentScan(basePackages = {
        "eu.mithril.training.spring.framework.ch04.model",
        "eu.mithril.training.spring.framework.ch04.dao"
})
public class Ex02_DB_JavaConfigured {

    public static void main(String[] args) {

        // Annotation based config loading
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Ex02_DB_JavaConfigured.class);
        context.refresh();

        ColoredShapeDao coloredShapeDao = context.getBean(ColoredShapeDao.class);

        // Create a new shape.
        coloredShapeDao.create(4, "teal", "trapezium");

        // List the three original plus the new shape.
        List<ColoredShape> coloredShapes = coloredShapeDao.listColoredShapes();
        for (ColoredShape coloredShape : coloredShapes) {
            System.out.println(coloredShape.toString());
        }

        // Update a shape.
        coloredShapeDao.update(1, "red", "rectangle");

        // List the updated table content.
        coloredShapes = coloredShapeDao.listColoredShapes();
        for (ColoredShape coloredShape : coloredShapes) {
            System.out.println(coloredShape.toString());
        }
    }
}