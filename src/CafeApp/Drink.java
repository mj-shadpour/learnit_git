package CafeApp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

class Drink {
    String name;
    double price;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " " + formatPrice(price);
    }


    public static String formatPrice(double price) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#,###", symbols);
        return df.format((long)price);
    }
}