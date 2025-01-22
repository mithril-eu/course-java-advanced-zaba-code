package eu.mithril.training.spring.framework.ch02.model;

import org.springframework.beans.factory.annotation.Autowired;

public class SetterAnnotatedColoredShapeHolder {

    private ColoredShape coloredShape = new ColoredShape();

    // default count is 1.
    private int quantity = 1;

    public SetterAnnotatedColoredShapeHolder() {
    }

    public SetterAnnotatedColoredShapeHolder(final ColoredShape coloredShape, int quantity) {

        this.coloredShape = coloredShape;
        this.quantity = quantity;
    }

    public ColoredShape getColoredShape() {

        return coloredShape;
    }

    // ************************************************************************
    // Notice the @Autowired annotation. This will pull the bean reference from the context.
    // ************************************************************************
    @Autowired
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
