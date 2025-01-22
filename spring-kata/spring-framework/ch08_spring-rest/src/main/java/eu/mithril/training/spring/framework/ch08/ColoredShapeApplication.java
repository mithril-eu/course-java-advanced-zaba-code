package eu.mithril.training.spring.framework.ch08;

import eu.mithril.training.spring.framework.ch08.config.ColoredShapeConfig;
import eu.mithril.training.spring.framework.ch08.controller.ColoredShapeController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ColoredShapeApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ColoredShapeConfig.class);
        ColoredShapeController coloredShapeControllingBean = context.getBean(ColoredShapeController.class);
        coloredShapeControllingBean.persistAndRetrieveColoredShapes();
    }
}
