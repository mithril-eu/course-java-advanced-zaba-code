package eu.mithril.training.spring.framework.ch06.dao;

import eu.mithril.training.spring.framework.ch06.model.ColoredShape;

public interface ColoredShapeDao {

    ColoredShape findById(final Long id);

    void save(ColoredShape coloredShape);

}