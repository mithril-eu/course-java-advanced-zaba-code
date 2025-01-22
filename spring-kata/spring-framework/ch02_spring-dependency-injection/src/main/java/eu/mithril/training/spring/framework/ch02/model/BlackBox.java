package eu.mithril.training.spring.framework.ch02.model;

import org.springframework.stereotype.Component;

@Component
public class BlackBox extends ColoredShape {

    public BlackBox() {
        super("black", "box");
    }
}