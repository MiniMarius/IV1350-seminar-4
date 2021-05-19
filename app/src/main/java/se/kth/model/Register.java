package se.kth.model;

/**
 * stores the money to be used for change for payments
 */
public class Register {
    private Double balance;

    public Register() {
        balance = 250.0;
    }

    /**
     * Calculates change of the amount in register after receiving payment for sale and returns the amount of change to give to customer
     *
     * @param payment the amount used to pay for the sale
     * @param sale    The sale instance used for calculating change of change
     */
    public Double calculateChange(Payment payment, Sale sale) {
        Double change = (payment.getAmount() - sale.getTotal());
        balance += sale.getTotal();
        return change;
    }

    /**
     * @param amount the amount to be added to the register
     */
    public void addToBalance(Double amount) {
        balance += amount;
    }

    /**
     * @param amount the amount to initially set the register to manually
     */
    public void setBalance(Double amount) {
        balance = amount;
    }

    /**
     * @return the amount of change inside register
     */
    public Double getBalance() {
        return balance;
    }

}
