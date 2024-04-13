package ge.tbc.tbcitacademy.POM.Util;

import java.text.DecimalFormat;

public class HelperFunctions {
    public static String formatCurrency(double value) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return df.format(value);
    }

    public static Double textToDouble(String text){
        return Double.parseDouble(text.trim().replaceAll("[^\\d.]", ""));
    }

    public static double calculatePercentage(double total, double percent) {
        if (total == 0) {
            throw new IllegalArgumentException("Total value cannot be zero");
        }
        return (total * percent) / 100.0;
    }
}
