package eu.mithril.training.spring.framework.ch03;

import eu.mithril.training.spring.framework.ch03.model.BulkVehicleOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


//TODO: Run this test with the right runner.
//TODO: custom XML context configuration to configure an order of 7 count of 2016 pickup.
public class Lab02Test {

    @Autowired
    private BulkVehicleOrder bulkVehicleOrder;

    @Test
    public void customXmlContextPath() {

        // TODO: Add a vehicle XML bean definition with id=vehicle as a 2016 pickup.
        // TODO: Add a bulkVehicleOrder XML bean definition with the above vehicle and quantity of 7.
        // UNCOMMENT BELOW CODE AND TEST.
/*
        assertEquals(
                7,
                bulkVehicleOrder.getQuantity(),
                "The quantity of vehicles should be [7]"
        );

        assertEquals(
                "2016 pickup",
                bulkVehicleOrder.getVehicle().toString(),
                "The shape should be [2016 pickup]"
        );
*/
    }

}
