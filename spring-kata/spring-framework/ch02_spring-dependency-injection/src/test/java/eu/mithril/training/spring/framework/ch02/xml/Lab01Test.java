package eu.mithril.training.spring.framework.ch02.xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Lab01Test {

    private ApplicationContext context;

    @BeforeEach
    public void setup() {

        context = new ClassPathXmlApplicationContext("test-inject-with-xml.xml");
    }

    @Test
    public void injectThroughConstructorSimple() {

        // TODO: Add a bean definition with id=vehicleThroughConstructor in the src/test/resources/test-inject-with-xml.xml
        // UNCOMMENT BELOW CODE AND FIX IT.
/*
        Vehicle vehicle = (Vehicle) context.getBean("vehicleThroughConstructor");
        assertEquals(
                "2017 car",
                vehicle.toString(),
                "The vehicle should be 2017 car"
        );
*/
    }

    @Test
    public void injectThroughConstructorNamed() {

        // TODO: Add a bean definition with id=vehicleThroughConstructorNamed in the src/test/resources/test-inject-with-xml.xml
        // TODO: Create a Vehicle with year = 2016 and type = truck.
        // UNCOMMENT BELOW CODE AND FIX IT.
/*
        Vehicle vehicle = (Vehicle) context.getBean("vehicleThroughConstructorNamed");
        assertEquals(
                "2016 truck",
                vehicle.toString(),
                "The vehicle should be 2016 truck"
        );
*/
    }

    @Test
    public void injectThroughConstructorIndex() {

        // TODO: Add a bean definition with id=vehicleThroughConstructorIndex in the src/test/resources/test-inject-with-xml.xml
        // TODO: Create a Vehicle with year = 2015 and type = bike.
        // UNCOMMENT BELOW CODE AND FIX IT.
/*
        Vehicle vehicle = (Vehicle) context.getBean("vehicleThroughConstructorIndex");
        assertEquals(
                "2015 bike",
                vehicle.toString(),
                "The vehicle should be 2015 bike"
        );
*/
    }

    @Test
    public void injectThroughSetters() {

        // TODO: Add a bean definition with id=vehicleThroughSetter in the src/test/resources/test-inject-with-xml.xml
        // TODO: Create a Vehicle with year = 2014 and type = airplane.
        // UNCOMMENT BELOW CODE AND FIX IT.
/*
        Vehicle vehicle = (Vehicle) context.getBean("vehicleThroughSetter");
        assertEquals(
                "2014 airplane",
                vehicle.toString(),
                "The vehicle should be 2014 airplane"
        );
*/
    }

}
