package eu.mithril.training.spring.framework.ch07.dao;

import org.springframework.data.repository.CrudRepository;

import eu.mithril.training.spring.framework.ch07.model.ColoredShape;

// No implementation !!! Only interface.

/**
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.data.repository.Repository
 */
public interface ColoredShapeDao extends CrudRepository<ColoredShape, Long> {

    // Notice how the save and findById (a.k.a findOne) methods are not even declared,
    // leave alone implemented.

    ColoredShape findByColor(final String color);

    ColoredShape findByShape(final String shape);
}