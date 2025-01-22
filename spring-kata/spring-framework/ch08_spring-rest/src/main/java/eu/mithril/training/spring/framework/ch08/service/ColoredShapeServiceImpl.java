package eu.mithril.training.spring.framework.ch08.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.mithril.training.spring.framework.ch08.dao.ColoredShapeDao;
import eu.mithril.training.spring.framework.ch08.model.ColoredShape;

@Service
@Transactional(readOnly = true)
public class ColoredShapeServiceImpl implements ColoredShapeService {

    @Autowired
    ColoredShapeDao coloredShapeDao;

    @Override
    public ColoredShape getColoredShape(final Long id) {
        Optional<ColoredShape> optionalColoredShape = coloredShapeDao.findById(id);

        return optionalColoredShape.orElse(null);
    }

    @Override
    public List<ColoredShape> findAll() {
        Iterable<ColoredShape> coloredShapeIterable = coloredShapeDao.findAll();

        List<ColoredShape> coloredShapes = Collections.emptyList();
        coloredShapeIterable.forEach(coloredShapes::add);

        return coloredShapes;
    }

    @Override
    @Transactional(readOnly = false)
    public void saveColoredShape(final ColoredShape coloredShape) {
        coloredShapeDao.save(coloredShape);
    }

    @Override
    public ColoredShape getColoredShapeByShape(final String shape) {
        return coloredShapeDao.findByShape(shape);
    }

    @Override
    public ColoredShape getColoredShapeByColor(final String color) {
        return coloredShapeDao.findByColor(color);
    }
}
