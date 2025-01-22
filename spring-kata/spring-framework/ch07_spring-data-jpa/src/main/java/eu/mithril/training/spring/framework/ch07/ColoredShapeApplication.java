package eu.mithril.training.spring.framework.ch07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eu.mithril.training.spring.framework.ch07.config.ColoredShapeConfig;
import eu.mithril.training.spring.framework.ch07.controller.ColoredShapeControllingBean;

public class ColoredShapeApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ColoredShapeConfig.class);

        ColoredShapeControllingBean coloredShapeControllingBean =
                context.getBean(ColoredShapeControllingBean.class);

        coloredShapeControllingBean.persistAndRetrieveColoredShapes();
    }
}