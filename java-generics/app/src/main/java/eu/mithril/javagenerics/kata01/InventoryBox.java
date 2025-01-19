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
        if (isSealed) {
            throw new IllegalStateException("Cannot store items in a sealed box");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Removes the specified quantity of items from the box.
     * @param count The number of items to remove
     * @throws IllegalStateException if attempting to remove more items than available
     */
    public void remove(int count) {
        if (isSealed) {
            throw new IllegalStateException("Cannot remove items from a sealed box");
        }
        if (count > this.quantity) {
            throw new IllegalStateException("Cannot remove more items than available");
        }
        this.quantity -= count;
        if (this.quantity == 0) {
            this.item = null;
        }
    }

    /**
     * Seals the box, preventing further modifications.
     */
    public void seal() {
        this.isSealed = true;
    }

    /**
     * Clears the box, removing all items.
     * @throws IllegalStateException if the box is sealed
     */
    public void clear() {
        if (isSealed) {
            throw new IllegalStateException("Cannot clear a sealed box");
        }
        this.item = null;
        this.quantity = 0;
    }

    /**
     * Gets the current item in the box.
     * @return The stored item, or null if empty
     */
    public T getItem() {
        return this.item;
    }

    /**
     * Gets the current quantity of items in the box.
     * @return The quantity of items
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Checks if the box is sealed.
     * @return true if the box is sealed, false otherwise
     */
    public boolean isSealed() {
        return this.isSealed;
    }
}