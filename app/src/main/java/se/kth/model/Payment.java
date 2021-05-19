package se.kth.model;

/**
 * Handles the amount of money used to pay for the sale
 */
public class Payment {
    private Double amount;

    public Payment(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the amount paid
     */
    public Double getAmount() {
        return amount;
    }


    public String toString() {
        return "" + amount;
    }
}
