package com.svg.java;

import com.svg.java.core.Invoice;
import com.svg.java.utils.TaxUtils;

public class Main {

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.setAmount(100);
        System.out.printf("Amount: %s %n", invoice.getAmountWithVAT());
        System.out.printf("Amount with VAT: %s %n", TaxUtils.calculateVAT(100));

    }


}
