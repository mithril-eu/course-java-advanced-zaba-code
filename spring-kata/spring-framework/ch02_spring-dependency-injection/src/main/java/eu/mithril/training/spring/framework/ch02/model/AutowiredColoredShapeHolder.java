package eu.mithril.training.spring.framework.ch02.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredColoredShapeHolder {

    private OrangeOval orangeOval;

    // default count is 1.
    private int quantity = 1;

    public AutowiredColoredShapeHolder() {
    }

    // ************************************************************************
    // Notice the @Autowired annotation. This will pull the bean reference from the context.
    // ************************************************************************
    @Autowired
    public AutowiredColoredShapeHolder(final OrangeOval orangeOval) {
        this.orangeOval = orangeOval;
    }

    public AutowiredColoredShapeHolder(final OrangeOval orangeOval, int quantity) {
        this.orangeOval = orangeOval;
        this.quantity = quantity;
    }

    public OrangeOval getColoredShape() {
        return orangeOval;
    }

    public void setColoredShape(final OrangeOval orangeOval) {
        this.orangeOval = orangeOval;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return quantity + " count of colored shape: [ " + orangeOval + " ]";
    }
}