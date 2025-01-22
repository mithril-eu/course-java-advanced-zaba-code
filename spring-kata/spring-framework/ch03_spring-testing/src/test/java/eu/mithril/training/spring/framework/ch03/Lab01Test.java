package eu.mithril.training.spring.framework.ch03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import eu.mithril.training.spring.framework.ch03.model.BulkVehicleOrder;

//TODO: Run this test with the right runner.
//TODO: Use default XML context configuration to configure an order of 10 count of 2017 car.
public class Lab01Test {

    @Autowired
    private BulkVehicleOrder bulkVehicleOrder;

    @Test
    public void defaultXmlContextPath() {

        // TODO: Add a vehicle XML bean definition with id=vehicle as a 2017 car.
        // TODO: Add a bulkVehicleOrder XML bean definition with the above vehicle and quantity of 10.
        // UNCOMMENT BELOW CODE AND TEST.
/*
        assertEquals(
                10,
                bulkVehicleOrder.getQuantity(),
                "The quantity of vehicles should be [10]"
        );

        assertEquals(
                "2017 car",
                bulkVehicleOrder.getVehicle().toString(),
                "The shape should be [2017 car]"
        );
*/
    }

}
