package eu.mithril.training.spring.framework.ch05;

import eu.mithril.training.spring.framework.ch05.config.ColoredShapeConfig;
import eu.mithril.training.spring.framework.ch05.controller.ColoredShapeControllingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ColoredShapeApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ColoredShapeConfig.class);

        ColoredShapeControllingBean coloredShapeControllingBean =
                context.getBean(ColoredShapeControllingBean.class);

        coloredShapeControllingBean.persistAndRetrieveColoredShapes();
    }
}