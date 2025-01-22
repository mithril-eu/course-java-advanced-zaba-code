package eu.mithril.training.spring.framework.ch03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import eu.mithril.training.spring.framework.ch03.model.ColoredShapeHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:/ex02.xml"})
public class Ex02_CustomXMLContextConfiguration {

    @Autowired
    private ColoredShapeHolder coloredShapeHolder;

    @Test
    public void customXmlContextPath() {
        assertEquals(
                5,
                coloredShapeHolder.getQuantity(),
                "The quantity of shapes should be [5]"
        );
        assertEquals(
                "red rhombus",
                coloredShapeHolder.getColoredShape().toString(),
                "The shape should be [red rhombus]"
        );
    }

}
