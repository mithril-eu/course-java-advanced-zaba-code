package eu.mithril.javagenerics.kata01;

/**
 * InventoryBox represents a storage container that can hold any type of inventory item.
 * It includes basic handling of quantity and sealing status.
 *
 * @param <T> the type of item stored in the box
 */
public class InventoryBox<T> {
    private T item;
    private int quantity;
    private boolean isSealed;

    public InventoryBox() {
        this.quantity = 0;
        this.isSealed = false;
    }

    /**
     * Stores an item with the specified quantity in the box.
     * @param item The item to store
     * @param quantity The quantity of items
     * @throws IllegalStateException if the box is sealed
     * @throws IllegalArgumentException if the quantity is negative
     */
    public void store(T item, int quantity) {
        return; // TODO: Implement this method
    }

    /**
     * Removes the specified quantity of items from the box.
     * @param count The number of items to remove
     * @throws IllegalStateException if attempting to remove more items than available
     */
    public void remove(int count) {
        return; // TODO: Implement this method
    }

    /**
     * Seals the box, preventing further modifications.
     */
    public void seal() {
        return; // TODO: Implement this method
    }

    /**
     * Clears the box, removing all items.
     * @throws IllegalStateException if the box is sealed
     */
    public void clear() {
        return; // TODO: Implement this method
    }

    /**
     * Gets the current item in the box.
     * @return The stored item, or null if empty
     */
    public T getItem() {
        return null; // TODO: Implement this method
    }

    /**
     * Gets the current quantity of items in the box.
     * @return The quantity of items
     */
    public int getQuantity() {
        return 0; // TODO: Implement this method
    }

    /**
     * Checks if the box is sealed.
     * @return true if the box is sealed, false otherwise
     */
    public boolean isSealed() {
        return false; // TODO: Implement this method
    }
}