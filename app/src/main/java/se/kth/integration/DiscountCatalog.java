package se.kth.integration;

import se.kth.model.Item;
import se.kth.model.Sale;

import java.util.ArrayList;

/**
 * Stores the requirements needed to obtain a discount, including discounted item-objects
 */
public class DiscountCatalog {
    private Discount discount;
    private Integer customerId;
    private ArrayList<Item> discountedItems = new ArrayList<>();

    /**
     * Creates a demo-list of discount rules with creation of DiscountCatalog instance
     */
    public DiscountCatalog(Integer customerId) {
        discountedItems.add(new Item("Kebab", "A bag of kebab-meat, 400 g", 135.0, 10.0, 8, 10));
        discountedItems.add(new Item("Nuggets extra thick", "A bag of chicken-nuggets", 50.0, 25.0, 3, 10));
        discountedItems.add(new Item("Sour Apple candy", "A bag of candy, green and yellow", 60.0, 25.0, 5, 10));
        discountedItems.add(new Item("ice-cream superIcy", "A big tub of ice cream", 22.0, 25.0, 6, 10));
        this.customerId = customerId;
    }

    /**
     * Calculates discount for customer if the discount rules are matched.
     * Discount is given if sale contains discounted items and
     * the customer id is matched with the one needed for a discount while the sale total is high enough
     *
     * @param idNumber The id to be compared to the stored customerId eligible for discount
     * @return Discount the created instance of Discount to be returned after calculating discount amount
     */
    public Discount calculateDiscount(Integer idNumber, Sale sale) {
        discount = new Discount();
        for (Item item : sale.getScannedItems()) {
            for (Item discountedItem : discountedItems) {
                if (item.getStoreKeepingUnitNumber().equals(discountedItem.getStoreKeepingUnitNumber())) {
                    if (idNumber.equals(customerId) && sale.getTotal() >= 100.0) {
                        discount.setDiscount(20.0);
                    } else if (idNumber.equals(customerId) && sale.getTotal() >= 50.0) {
                        discount.setDiscount(10.0);
                    }
                }
            }
        }
        return discount;
    }
}
