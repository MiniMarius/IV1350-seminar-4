package se.kth.integration;

/**
 * contains the discount to be applied to a Sale
 */
public class Discount {
    private Double discount;

    public Discount() {
    }

    /**
     * @param amount - the amount to be set as discount amount
     */
    public void setDiscount(Double amount) {
        discount = amount;
    }

    /**
     * @return discount amount
     */
    public Double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "" + discount;
    }
}
