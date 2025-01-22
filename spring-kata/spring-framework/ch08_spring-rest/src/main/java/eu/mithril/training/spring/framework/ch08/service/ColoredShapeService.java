package eu.mithril.training.spring.framework.ch08.service;

import java.util.List;

import eu.mithril.training.spring.framework.ch08.model.ColoredShape;

public interface ColoredShapeService {

    ColoredShape getColoredShape(Long id);

    List<ColoredShape> findAll();

    void saveColoredShape(ColoredShape coloredShape);

    ColoredShape getColoredShapeByShape(String shape);

    ColoredShape getColoredShapeByColor(String color);
}
