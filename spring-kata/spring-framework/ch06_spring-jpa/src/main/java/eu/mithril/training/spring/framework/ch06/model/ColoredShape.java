package eu.mithril.training.spring.framework.ch06.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COLORED_SHAPE")
public class ColoredShape implements Serializable {

    private static final long serialVersionUID = 4784487603905008443L;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
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
        return "ID: [" + id + "]: Color: [" + color + "], Shape: [" + shape +"]";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColoredShape that = (ColoredShape) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        return shape != null ? shape.equals(that.shape) : that.shape == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (shape != null ? shape.hashCode() : 0);
        return result;
    }
}