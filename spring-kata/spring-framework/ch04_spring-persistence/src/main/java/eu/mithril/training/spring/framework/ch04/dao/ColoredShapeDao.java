package eu.mithril.training.spring.framework.ch04.dao;

import java.util.List;

import eu.mithril.training.spring.framework.ch04.model.ColoredShape;

public interface ColoredShapeDao {

    /**
     * C of the CRUD Create a ColoredShape.
     */
    void create(int id, String color, String shape);

    /**
     * R of the CRUD Read a ColoredShape from the table corresponding to an id.
     */
    ColoredShape getColoredShape(int id);

    /**
     * R of the CRUD Read all ColoredShape instnces in the table
     */
    List<ColoredShape> listColoredShapes();

    /**
     * U of the CRUD Update a ColoredShape
     */
    void update(int id, String color, String shape);

    /**
     * D of the CRUD Delete a ColoredShape from the table corresponding to a an id.
     */
    void delete(int id);

}