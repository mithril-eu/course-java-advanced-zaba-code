package eu.mithril.training.spring.framework.ch03.model;

// TODO: Fix this class to Autowire using a setter
public class BulkVehicleOrder {

    private Vehicle vehicle;
    private int quantity = 1;

    public BulkVehicleOrder() {
    }

    public BulkVehicleOrder(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BulkVehicleOrder(final Vehicle vehicle, final int quantity) {
        this.vehicle = vehicle;
        this.quantity = quantity;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return quantity + " " + "count of " + vehicle.toString();
    }
}
