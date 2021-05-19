package se.kth.integration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.kth.model.Item;

class ItemNotFoundExceptionTest {

    @Test
    public void testCheckInventoryThrowsItemNotFoundException() {
        ExternalInventorySystem eis = new ExternalInventorySystem();
        Item item = new Item();
        Integer itemId = 20;
        Integer wantedAmount = 2;
        Assertions.assertThrows(ItemNotFoundException.class, () -> {
            eis.checkInventory(itemId, wantedAmount);
        });
    }
}