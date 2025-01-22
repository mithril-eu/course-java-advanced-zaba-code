package eu.mithril.training.spring.framework.ch03.model;

import org.springframework.stereotype.Component;

@Component
public class ColoredShapeHolder {

    private ColoredShape coloredShape = new ColoredShape();

    // default count is 1.
    private int quantity = 1;

    public ColoredShapeHolder() {
    }

    public ColoredShapeHolder(final ColoredShape coloredShape, int quantity) {
        this.coloredShape = coloredShape;
        this.quantity = quantity;
    }

    public ColoredShape getColoredShape() {
        return coloredShape;
    }

    public void setColoredShape(final ColoredShape coloredShape) {
        this.coloredShape = coloredShape;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return quantity + " count of colored shape: [ " + coloredShape + " ]";
    }
}
