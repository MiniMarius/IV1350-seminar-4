package se.kth.view;

import se.kth.model.SaleObserver;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * responsible for logging/printing total revenue since start of application to file
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private Double revenue;

    public TotalRevenueFileOutput() {
        revenue = 0.0;
    }

    /**
     * adds payment amount to revenue and prints revenue to file
     *
     * @param amount the amount of completed sale
     */
    @Override
    public void updateRevenue(Double amount) {
        revenue += amount;
        try {
            logRevenue();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * prints total income to file.
     * Throws exception if file can't be found
     *
     * @throws FileNotFoundException
     */
    private void logRevenue() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("revenue.txt");
        printWriter.println(revenue);
        printWriter.close();
    }
}
