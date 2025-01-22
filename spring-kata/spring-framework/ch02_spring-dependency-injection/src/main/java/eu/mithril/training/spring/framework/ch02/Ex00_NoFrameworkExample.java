package eu.mithril.training.spring.framework.ch02;

import eu.mithril.training.spring.framework.ch02.model.ColoredShapeHolder;
import eu.mithril.training.spring.framework.ch02.model.RedRectangle;
import eu.mithril.training.spring.framework.ch02.model.ColoredShape;
import eu.mithril.training.spring.framework.ch02.model.CyanCylinder;

public class Ex00_NoFrameworkExample {

    public static void main(String[] args) {

        ColoredShapeHolder coloredShapeHolder = new ColoredShapeHolder();

        //Should print "1 count of colored shape: [ green circle ]"
        System.out.println(coloredShapeHolder);

        // ---------------------------------------------------------------------------------------

        ColoredShape redRectangle = new RedRectangle();

        // Create a holder of 5 red rectangles
        ColoredShapeHolder redRectangleHolder =
                new ColoredShapeHolder(redRectangle, 5);

        //Should print "5 count of colored shape: [ red rectangle ]"
        System.out.println(redRectangleHolder);

        // ---------------------------------------------------------------------------------------

        ColoredShape cyanCylinder = new CyanCylinder();

        // Create a holder of 7 cyan cylinders
        ColoredShapeHolder cyanCylinderHolder =
                new ColoredShapeHolder(cyanCylinder, 7);

        //Should print "7 count of colored shape: [ cyan cylinder ]"
        System.out.println(cyanCylinderHolder);

        // ---------------------------------------------------------------------------------------

        ColoredShape blackBox = new ColoredShape();
        blackBox.setColor("black");
        blackBox.setType("box");

        // Create a holder of 3 black box
        ColoredShapeHolder blackBoxHolder = new ColoredShapeHolder();
        blackBoxHolder.setColoredShape(blackBox);
        blackBoxHolder.setQuantity(3);

        //Should print "3 count of colored shape: [ black box ]"
        System.out.println(blackBoxHolder);
    }
}