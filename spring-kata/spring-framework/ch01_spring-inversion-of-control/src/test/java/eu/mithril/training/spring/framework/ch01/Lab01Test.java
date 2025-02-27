package eu.mithril.training.spring.framework.ch01;

import eu.mithril.training.spring.framework.ch01.model.VehicleFactory;
import eu.mithril.training.spring.framework.ch01.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @see Vehicle
 * @see VehicleFactory
 */
@DisplayName("Inversion of Control using: ")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Lab01Test {

    private ApplicationContext context;

    @BeforeEach
    public void setup() {

        context =
                new ClassPathXmlApplicationContext(
                        "test-instantiation-spring-config.xml");
    }

    @Test
    @DisplayName("a constructor in XML config")
    @Order(1)
    public void instantiateThroughConstructor() {

        // TODO: Add a bean definition with id=vehicleThroughConstructor in the
        //  src/test/resources/test-instantiation-spring-config.xml
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
    @DisplayName("a static factory in XML config")
    @Order(2)
    public void instantiateThroughStaticFactory() {

        // TODO: Add a bean definition with id=vehicleThroughStaticFactory in the
        //  src/test/resources/test-instantiation-spring-config.xml
        // TODO: Fill out the static method to the VehicleFactory class to return
        //  a Vehicle with year = 2016 and type = truck.
        // UNCOMMENT BELOW CODE AND FIX IT.
/*
        Vehicle vehicle = (Vehicle) context.getBean("vehicleThroughStaticFactory");
        assertEquals(
                "2016 truck",
                vehicle.toString(),
                "The vehicle should be 2016 truck"
        );
*/
    }

    @Test
    @DisplayName("an instance factory in XML config")
    @Order(3)
    public void instantiateThroughInstanceFactory() {

        // TODO: Add a bean definition with id=vehicleFactory in the
        //  src/test/resources/test-instantiation-spring-config.xml
        // TODO: Add a bean definition with id=vehicleThroughInstanceFactory in the
        //  src/test/resources/test-instantiation-spring-config.xml
        // TODO: Fill out the instance method to the VehicleFactory class to return
        //  a Vehicle with year = 2015 and type = bike.
        // UNCOMMENT BELOW CODE AND FIX IT.
/*
        Vehicle vehicle = (Vehicle) context.getBean("vehicleThroughInstanceFactory");
        assertEquals(
                "2015 bike",
                vehicle.toString(),
                "The vehicle should be 2015 bike"
        );
*/
    }
}