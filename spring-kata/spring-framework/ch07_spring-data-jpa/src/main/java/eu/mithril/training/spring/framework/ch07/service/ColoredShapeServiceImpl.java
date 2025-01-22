package eu.mithril.training.spring.framework.ch07.service;

import java.util.Optional;

import eu.mithril.training.spring.framework.ch07.dao.ColoredShapeDao;
import eu.mithril.training.spring.framework.ch07.model.ColoredShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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