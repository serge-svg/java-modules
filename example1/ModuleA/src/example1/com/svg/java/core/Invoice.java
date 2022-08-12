package example1.com.svg.java.core;

import example1.com.svg.java.utils.TaxUtils;

public class Invoice {

    private int number;
    private String concept;
    private double amount;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountWithVAT() {
        return TaxUtils.calculateVAT(this.amount);
    }

}
