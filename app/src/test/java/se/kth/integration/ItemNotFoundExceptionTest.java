package se.kth.integration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * testing that ItemNotFoundException is thrown when it should
 */
class ItemNotFoundExceptionTest {

    /**
     * checks that custom exception is thrown when itemId can't be found
     * checks that the message is correct
     */
    @Test
    public void testCheckInventoryThrowsItemNotFoundException() {
        Integer itemId = 20;
        Integer wantedAmount = 2;
        ExternalInventorySystem eis = new ExternalInventorySystem();
        Throwable exception = Assertions.assertThrows(ItemNotFoundException.class, () -> {
            eis.checkInventory(itemId, wantedAmount);
        });
        Assertions.assertTrue(exception.getMessage().equals("The item with the itemID "+ itemId + " was not found"));
    }

    /**
     * testing that CheckInventory doesn't throw any exceptions during normal execution.
     * ItemId is existing in inventory system
     */
    @Test
    public void testCheckInventoryNormalExecution() {
        Integer itemId = 3;
        Integer wantedAmount = 2;
        ExternalInventorySystem eis = new ExternalInventorySystem();
        Assertions.assertDoesNotThrow(() -> eis.checkInventory(itemId, wantedAmount));
    }

    /**
     * testing that a checked NullPointerException is thrown when null is given as parameter
     *
     */
    @Test
    public void testCheckInventoryWhenAmountIsNull() {
        Integer itemId = 3;
        Integer wantedAmount = null;
        ExternalInventorySystem eis = new ExternalInventorySystem();
        Assertions.assertThrows(NullPointerException.class, () -> eis.checkInventory(itemId, wantedAmount));
    }
}