package eu.mithril.training.spring.framework.ch05.service;

import eu.mithril.training.spring.framework.ch05.model.ColoredShape;

public interface ColoredShapeService {

    ColoredShape getColoredShape(Long id);

    void addColoredShape(ColoredShape coloredShape);

}