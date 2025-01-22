package eu.mithril.training.spring.framework.ch03;

import eu.mithril.training.spring.framework.ch03.model.BulkVehicleOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO: Run this test with the right runner.
//TODO: Configure using the Lab03DIConfiguration
//TODO: Create the two qualified bulk vehicle orders "2 count of 2016 plane" and "6 count of 2017 flatbed" in Lab03DIConfiguration.
public class Lab03Test {

    @Autowired
    @Qualifier("twoPlane2016Order")
    private BulkVehicleOrder twoPlane2016Order;

    @Autowired
    @Qualifier("sixFlatbed2017Order")
    private BulkVehicleOrder sixFlatbed2017Order;

    @Test
    public void testingTheTwoPlane2016Order() {

        // UNCOMMENT BELOW CODE AND TEST.
/*
        assertEquals(
                2,
                twoPlane2016Order.getQuantity(),
                "The quantity of shapes should be [2]"
        );

        assertEquals(
                "2016 plane",
                twoPlane2016Order.getVehicle().toString(),
                "The shape should be [2016 plane]"
        );
*/
    }

    @Test
    public void testingTheSixFlatbed2017Order() {
        // UNCOMMENT BELOW CODE AND TEST.
/*
        assertEquals(
                6,
                sixFlatbed2017Order.getQuantity(),
                "The quantity of shapes should be [6]"
        );

        assertEquals(
                "2017 flatbed",
                sixFlatbed2017Order.getVehicle().toString(),
                "The shape should be [2017 flatbed]"
        );
*/
    }
}
