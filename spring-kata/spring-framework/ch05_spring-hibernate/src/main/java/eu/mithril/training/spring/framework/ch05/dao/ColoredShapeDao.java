package eu.mithril.training.spring.framework.ch05.dao;

import eu.mithril.training.spring.framework.ch05.model.ColoredShape;

public interface ColoredShapeDao {

    ColoredShape findById(final Long id);

    void save(ColoredShape coloredShape);
}