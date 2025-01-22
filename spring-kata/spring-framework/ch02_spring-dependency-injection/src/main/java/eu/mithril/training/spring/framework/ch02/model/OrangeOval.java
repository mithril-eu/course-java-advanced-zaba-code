package eu.mithril.training.spring.framework.ch02.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("orangeOval")
public class OrangeOval extends ColoredShape {

    public OrangeOval() {

        super("orange", "oval");
    }
}