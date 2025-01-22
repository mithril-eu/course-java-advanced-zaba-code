package eu.mithril.training.spring.framework.ch06.service;

import eu.mithril.training.spring.framework.ch06.model.ColoredShape;

public interface ColoredShapeService {

    ColoredShape getColoredShape(Long id);

    void addColoredShape(ColoredShape coloredShape);
}
