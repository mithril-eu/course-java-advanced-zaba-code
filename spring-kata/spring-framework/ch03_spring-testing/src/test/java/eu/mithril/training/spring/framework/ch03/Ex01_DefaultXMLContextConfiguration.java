package eu.mithril.training.spring.framework.ch03;

import eu.mithril.training.spring.framework.ch03.model.ColoredShapeHolder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class Ex01_DefaultXMLContextConfiguration {

    @Autowired
    private ColoredShapeHolder coloredShapeHolder;

    @Test
    public void defaultXmlContextPath() {
        assertEquals(
                2,
                coloredShapeHolder.getQuantity(),
                "The quantity of shapes should be [2]");

        assertEquals(
                "orange oval",
                coloredShapeHolder.getColoredShape().toString(),
                "The shape should be [orange oval]");
    }
}
