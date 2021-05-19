package se.kth.integration;

import java.util.ArrayList;

import se.kth.model.Item;
import se.kth.model.SaleInformation;

/**
 * Class representing a external inventory system with items stored in an Arraylist of items objects.
 */
public class ExternalInventorySystem {
    private ArrayList<Item> itemsInStock = new ArrayList<>();

    /**
     * adding demo items to the Arraylist of items during the creation of EAS for use in the sample execution
     */
    public ExternalInventorySystem() {
        itemsInStock.add(new Item("Kebab", "A bag of kebab-meat, 400 g", 135.0, 10.0, 8, 50));
        itemsInStock.add(new Item("Nuggets extra thick", "A bag of chicken-nuggets", 50.0, 25.0, 3, 50));
        itemsInStock.add(new Item("Sour Apple candy", "A bag of candy, green and yellow", 60.0, 25.0, 5, 50));
        itemsInStock.add(new Item("ice-cream superIcy", "A big tub of ice cream", 22.0, 25.0, 6, 50));
    }

    /**
     * Checks inventory for item with matching itemId and if it's in stock
     *
     * @param itemId the id which match with item in stock
     * @return foundItem a copy of found item in stock with the wanted amount inside
     * @throws ItemNotFoundException    if no id is matched with searched id
     * @throws DatabaseNotFoundException if id is equal to 420
     */
    public Item checkInventory(Integer itemId, Integer wantedAmount) throws ItemNotFoundException, DatabaseNotFoundException {
        if (itemId == 420) {
            throw new DatabaseNotFoundException("database connection timed out");
        }
        for (Item item : itemsInStock) {
            if (item.getStoreKeepingUnitNumber().equals(itemId) && item.getAmount() >= wantedAmount) {
                Item foundItem = new Item(item);
                foundItem.setAmount(wantedAmount);
                return foundItem;
            }
        }
        throw new ItemNotFoundException("The item with the itemID " + itemId + " was not found");
    }

    /**
     * Compares amount of sold items with items in stock and removing sold items from stock i.e keeping inventory up to date
     *
     * @param saleInformation instance of SaleInformation which holds an ArrayList of items to be compared with stock
     */
    public void updateInventory(SaleInformation saleInformation) {
        for (Item boughtItem : saleInformation.getBoughtItems()) {
            for (Item itemInStock : itemsInStock) {
                if (itemInStock.getStoreKeepingUnitNumber().equals(boughtItem.getStoreKeepingUnitNumber())) {
                    itemInStock.reduceAmount(boughtItem.getAmount());
                }
            }
        }
    }

    /**
     * @return returns whole Arraylist of items in stock
     */
    public ArrayList<Item> getAllItemsInStock() {
        return itemsInStock;
    }
}
