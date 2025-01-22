package eu.mithril.training.spring.framework.ch04.model;


import org.springframework.stereotype.Component;

// A Spring bean
@Component
public class ColoredShape {

    private Long id;

    // default color
    protected String color = "green";

    // default shape
    protected String shape = "circle";

    public ColoredShape() {
    }

    public ColoredShape(final String color, final String shape) {
        if (color != null) {
            this.color = color;
        }
        if (shape != null) {
            this.shape = shape;
        }
    }

    public ColoredShape(final Long id, final String color, final String shape) {
        this.id = id;
        this.color = color;
        this.shape = shape;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(final String type) {
        this.shape = type;
    }

    public String toString() {
        return "ID: [" + id + "]: Color: [" + color + "], Shape: [" + shape + "]";
    }
}