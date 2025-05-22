package com.yearup.dealership;

/**
 * Class representing a sales contract for vehicle purchases
 * Extends abstract Contract class
 */
public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05; // 5%
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_UNDER_10K = 295.00;
    private static final double PROCESSING_FEE_OVER_10K = 495.00;
    private static final double INTEREST_RATE_UNDER_10K = 0.0525; // 5.25%
    private static final double INTEREST_RATE_OVER_10K = 0.0425; // 4.25%
    private static final int LOAN_TERM_UNDER_10K = 24; // months
    private static final int LOAN_TERM_OVER_10K = 48; // months

    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;

    /**
     * Constructor for SalesContract
     * @param date Date of the contract
     * @param customerName Name of the customer
     * @param customerEmail Email of the customer
     * @param vehicle Vehicle being sold
     * @param isFinanced Whether the vehicle will be financed
     */
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicle);
        this.isFinanced = isFinanced;
        this.salesTaxAmount = calculateSalesTax();
        this.recordingFee = RECORDING_FEE;
        this.processingFee = (vehicle.getPrice() < 10000) ? PROCESSING_FEE_UNDER_10K : PROCESSING_FEE_OVER_10K;
    }

    // Getters and setters
    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    /**
     * Calculates sales tax based on vehicle price
     * @return the sales tax amount
     */
    private double calculateSalesTax() {
        return getVehicle().getPrice() * SALES_TAX_RATE;
    }

    /**
     * Calculates total price including all fees
     * @return the total contract price
     */
    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    /**
     * Calculates monthly payment if financed
     * Uses different interest rates and terms based on vehicle price
     * @return the monthly payment amount (0 if not financed)
     */
    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0.0;
        }

        double vehiclePrice = getVehicle().getPrice();
        double loanAmount = getTotalPrice();

        // Determine loan parameters based on vehicle price
        double interestRate;
        int loanTermMonths;

        if (vehiclePrice < 10000) {
            interestRate = INTEREST_RATE_UNDER_10K;
            loanTermMonths = LOAN_TERM_UNDER_10K;
        } else {
            interestRate = INTEREST_RATE_OVER_10K;
            loanTermMonths = LOAN_TERM_OVER_10K;
        }

        // Monthly interest rate
        double monthlyRate = interestRate / 12;

        // Calculate monthly payment using loan formula
        return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -loanTermMonths));
    }

    /**
     * Returns a formatted string representation for saving to file
     * @return formatted string with all contract details
     */
    @Override
    public String toString() {
        return "SALE|" + getDate() + "|" + getCustomerName() + "|" + getCustomerEmail() + "|" +
                getVehicle().getVin() + "|" + getVehicle().getYear() + "|" + getVehicle().getMake() + "|" +
                getVehicle().getModel() + "|" + getVehicle().getVehicleType() + "|" + getVehicle().getColor() + "|" +
                getVehicle().getOdometer() + "|" + getVehicle().getPrice() + "|" +
                getSalesTaxAmount() + "|" + getRecordingFee() + "|" + getProcessingFee() + "|" +
                getTotalPrice() + "|" + (isFinanced ? "YES" : "NO") + "|" + getMonthlyPayment();
    }
}