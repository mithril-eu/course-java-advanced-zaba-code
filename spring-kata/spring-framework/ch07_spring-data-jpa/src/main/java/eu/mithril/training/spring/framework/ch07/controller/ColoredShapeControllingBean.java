package eu.mithril.training.spring.framework.ch07.controller;

import eu.mithril.training.spring.framework.ch07.model.ColoredShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.mithril.training.spring.framework.ch07.service.ColoredShapeService;

@Component
public class ColoredShapeControllingBean {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ColoredShapeControllingBean.class);

    private ColoredShapeService coloredShapeService;

    @Autowired
    public void setColoredShapeService(final ColoredShapeService coloredShapeService) {

        this.coloredShapeService = coloredShapeService;
    }

    public void persistAndRetrieveColoredShapes() {

        ColoredShape coloredShape1 = new ColoredShape("teal", "trapezoid");
        ColoredShape coloredShape2 = new ColoredShape("turquoise", "triangle");

        LOGGER.info("\n\n\nPersisting the colored shapes:");
        // Save new colored shape
        coloredShapeService.saveColoredShape(coloredShape1);
        coloredShapeService.saveColoredShape(coloredShape2);


        // Get saved colored shape
        LOGGER.info("\n\n\nRetrieving ColoredShape 2:");
        ColoredShape fetched = coloredShapeService.getColoredShape(2L);
        LOGGER.info(fetched.toString());

        LOGGER.info("\n\n\nRetrieving ColoredShape 1:");
        fetched = coloredShapeService.getColoredShape(1L);
        LOGGER.info(fetched.toString());

        fetched.setShape("tetrahedron");
        coloredShapeService.saveColoredShape(fetched);

        LOGGER.info("\n\n\nUpdating ColoredShape 1:");
        fetched = coloredShapeService.getColoredShape(1L);
        LOGGER.info(fetched.toString());

        LOGGER.info("\n\n\nMagic ColoredShape:");
        fetched = coloredShapeService.getColoredShapeByShape("triangle");
        LOGGER.info(fetched.toString());

        LOGGER.info("\n\n\nMagic ColoredShape:");
        fetched = coloredShapeService.getColoredShapeByColor("teal");
        LOGGER.info(fetched.toString());
    }
}