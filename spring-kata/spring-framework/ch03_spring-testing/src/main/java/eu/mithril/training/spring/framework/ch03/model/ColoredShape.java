package eu.mithril.training.spring.framework.ch03.model;


import org.springframework.stereotype.Component;

// A Spring bean
@Component
public class ColoredShape {
    // default color
    protected String color = "green";

    // default shape
    protected String type = "circle";

    public ColoredShape() {
    }

    public ColoredShape(final String color, final String type) {
        if (color != null) {
            this.color = color;
        }
        if (type != null) {
            this.type = type;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String toString() {
        return color + ' ' + type;
    }

}