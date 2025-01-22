package eu.mithril.training.spring.framework.ch03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import eu.mithril.training.spring.framework.ch03.model.ColoredShapeHolder;
import eu.mithril.training.spring.framework.ch03.model.DIConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DIConfiguration.class})
public class Ex03_JavaContextConfiguration {

    @Autowired
    @Qualifier("tealTrapezoidHolder")
    private ColoredShapeHolder tealTrapezoidHolder;

    @Autowired
    @Qualifier("pinkPolygonHolder")
    private ColoredShapeHolder pinkPolygonHolder;

    @Test
    public void tealTrapezoidHolder() {
        assertEquals(
                10,
                tealTrapezoidHolder.getQuantity(),
                "The quantity of shapes should be [10]"
        );
        assertEquals(
                "teal trapezoid",
                tealTrapezoidHolder.getColoredShape().toString(),
                "The shape should be [teal trapezoid]"
        );
    }

    @Test
    public void pinkPolygonHolder() {
        assertEquals(
                7,
                pinkPolygonHolder.getQuantity(),
                "The quantity of shapes should be [7]"
        );
        assertEquals(
                "pink polygon",
                pinkPolygonHolder.getColoredShape().toString(),
                "The shape should be [pink polygon]"
        );
    }
}
