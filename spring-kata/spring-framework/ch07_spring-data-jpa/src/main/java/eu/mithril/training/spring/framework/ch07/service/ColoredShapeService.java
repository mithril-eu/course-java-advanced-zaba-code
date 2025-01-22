package eu.mithril.training.spring.framework.ch07.service;

import eu.mithril.training.spring.framework.ch07.model.ColoredShape;

public interface ColoredShapeService {

    ColoredShape getColoredShape(Long id);

    void saveColoredShape(ColoredShape coloredShape);

    ColoredShape getColoredShapeByShape(String shape);

    ColoredShape getColoredShapeByColor(String color);
}