package eu.mithril.training.spring.framework.ch02.annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab02Test {
    
    private ApplicationContext context;

    @BeforeEach
    public void setup() {

    }

    @Test
    public void injectThroughSetterAnnotation() {
        context = new ClassPathXmlApplicationContext("test-inject-with-annotations1.xml");

        // TODO: Add a bean definition with id=vehicle as a 2017 car in the src/test/resources/test-inject-with-annotations1.xml
        // TODO: Add a bean definition with id=setterAnnotatedBulkVehicleOrder in the src/test/resources/test-inject-with-annotations1.xml
        // TODO: 'Wire' the setter for the vehicle, in the SetterAnnotatedBulkVehicleOrder.java
        // UNCOMMENT BELOW CODE AND FIX IT.
/*
        SetterAnnotatedBulkVehicleOrder setterAnnotatedBulkVehicleOrder =
                (SetterAnnotatedBulkVehicleOrder) context.getBean("setterAnnotatedBulkVehicleOrder");
        assertEquals(
                "1 count of 2017 car",
                setterAnnotatedBulkVehicleOrder.toString(),
                "The order should be: 1 count of 2017 car"
        );
*/
    }

    @Test
    public void injectThroughConstructor() {
        context = new ClassPathXmlApplicationContext("test-inject-with-annotations2.xml");

        // TODO: Add a bean definition with id=vehicle as a 2016 truck in the src/test/resources/test-inject-with-annotations2.xml
        // TODO: Add a bean definition with id=constructorAnnotatedBulkVehicleOrder in the src/test/resources/test-inject-with-annotations2.xml
        // TODO: 'Wire' the setter for the vehicle, in the ConstructorAnnotatedBulkVehicleOrder.java
        // UNCOMMENT BELOW CODE AND FIX IT.
/*
        ConstructorAnnotatedBulkVehicleOrder constructorAnnotatedBulkVehicleOrder =
                (ConstructorAnnotatedBulkVehicleOrder) context.getBean("constructorAnnotatedBulkVehicleOrder");
        assertEquals(
                "5 count of 2016 truck",
                constructorAnnotatedBulkVehicleOrder.toString(),
                "The order should be: 5 count of 2016 truck"
        );
*/
    }

    @Test
    public void injectThroughConstructorWithQualifier() {
        context = new ClassPathXmlApplicationContext("test-inject-with-annotations3.xml");

        // TODO: Add a bean definition with id=vehicle as a 2014 airplane, with a qualifier, in the src/test/resources/test-inject-with-annotations3.xml
        // TODO: Add a bean definition with id=vehicle2 as a 2017 car, with a qualifier, in the src/test/resources/test-inject-with-annotations3.xml
        // TODO: Add a bean definition with id=constructorAnnotatedWithQualifierBulkVehicleOrder in the src/test/resources/test-inject-with-annotations3.xml
        // TODO: 'Wire' the constructor for the 'vehicle', with a qualifier, in the ConstructorAnnotatedWithQualifierBulkVehicleOrder.java
        // UNCOMMENT BELOW CODE AND FIX IT.
/*
        ConstructorAnnotatedWithQualifierBulkVehicleOrder constructorAnnotatedWithQualifierBulkVehicleOrder =
                (ConstructorAnnotatedWithQualifierBulkVehicleOrder) context.getBean("constructorAnnotatedWithQualifierBulkVehicleOrder");
        assertEquals(
                "7 count of 2014 airplane",
                constructorAnnotatedWithQualifierBulkVehicleOrder.toString(),
                "The order should be: 7 count of 2014 airplane"
        );
*/
    }

}
