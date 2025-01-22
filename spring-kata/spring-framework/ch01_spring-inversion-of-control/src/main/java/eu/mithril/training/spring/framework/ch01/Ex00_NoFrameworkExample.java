package eu.mithril.training.spring.framework.ch01;

import eu.mithril.training.spring.framework.ch01.model.ColoredShape;

public class Ex00_NoFrameworkExample {

    public static void main(String[] args) {

        String color = "pink";

        String type = "polygon";

        // We are 'controlling' color through the command line argument.
        if (args.length > 0) {
            if (args[0] != null && args[0].length() > 0) {
                color = args[0];
            }
            if (args.length > 1 && args[1] != null && args[1].length() > 0) {
                type = args[1];
            }
        }

        ColoredShape coloredShape = new ColoredShape(color, type);

        System.out.println(coloredShape);
    }
}