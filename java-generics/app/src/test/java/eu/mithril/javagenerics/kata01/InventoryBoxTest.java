package eu.mithril.javagenerics.kata01;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Kata: Generic Inventory Box
 * The goal of this kata is to create a generic container that can store any type
 * of inventory item while maintaining type safety and proper handling of the items.
 * This simulates a real-world scenario of managing different types of items in a
 * warehouse or document storage system.
 */
@DisplayName("Inventory Box Kata Tests")
public class InventoryBoxTest {

    @Test
    @DisplayName("Should store and retrieve a product correctly")
    void shouldStoreAndRetrieveProduct() {
        InventoryBox<Product> box = new InventoryBox<>();
        Product laptop = new Product("Laptop", 999.99);

        box.store(laptop, 1);

        assertEquals(laptop, box.getItem());
        assertEquals(1, box.getQuantity());
    }

    @Test
    @DisplayName("Should store and retrieve a document correctly")
    void shouldStoreAndRetrieveDocument() {
        InventoryBox<Document> box = new InventoryBox<>();
        Document contract = new Document("Contract", "Terms and conditions", true);

        box.store(contract, 1);

        assertEquals(contract, box.getItem());
        assertTrue(box.getItem().isConfidential());
    }

    @Test
    @DisplayName("Should not allow changes after sealing")
    void shouldNotAllowChangesAfterSealing() {
        InventoryBox<Product> box = new InventoryBox<>();
        Product phone = new Product("Phone", 599.99);

        box.store(phone, 5);
        box.seal();

        assertThrows(IllegalStateException.class, () -> {
            box.store(new Product("Tablet", 299.99), 1);
        });
    }

    @Test
    @DisplayName("Should handle multiple items correctly")
    void shouldHandleMultipleItems() {
        InventoryBox<Product> box = new InventoryBox<>();
        Product mouse = new Product("Mouse", 29.99);

        box.store(mouse, 10);
        assertEquals(10, box.getQuantity());

        box.remove(3);
        assertEquals(7, box.getQuantity());
    }

    @Test
    @DisplayName("Should not allow negative quantities")
    void shouldNotAllowNegativeQuantities() {
        InventoryBox<Product> box = new InventoryBox<>();
        Product keyboard = new Product("Keyboard", 49.99);

        assertThrows(IllegalArgumentException.class, () -> {
            box.store(keyboard, -1);
        });
    }

    @Test
    @DisplayName("Should not allow removing more items than available")
    void shouldNotAllowRemovingMoreThanAvailable() {
        InventoryBox<Document> box = new InventoryBox<>();
        Document report = new Document("Report", "Annual Report 2024", false);

        box.store(report, 5);

        assertThrows(IllegalStateException.class, () -> {
            box.remove(6);
        });
    }

    @Test
    @DisplayName("Should handle empty box correctly")
    void shouldHandleEmptyBox() {
        InventoryBox<Product> box = new InventoryBox<>();

        assertNull(box.getItem());
        assertEquals(0, box.getQuantity());
        assertFalse(box.isSealed());
    }

    @Test
    @DisplayName("Should allow clearing unsealed box")
    void shouldAllowClearingUnsealedBox() {
        InventoryBox<Product> box = new InventoryBox<>();
        Product printer = new Product("Printer", 299.99);

        box.store(printer, 2);
        box.clear();

        assertNull(box.getItem());
        assertEquals(0, box.getQuantity());
    }
}