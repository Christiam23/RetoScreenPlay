package com.caguilar.vivaair.util;

public class PriceUtil {

    public static int castPrice(String texto) {
        return Integer.parseInt(texto.split(" ")[1].replace(",", ""));
    }

    public static int castPriceSummary(String texto) {
        return Integer.parseInt(texto.split(" ")[2].replace(",", ""));
    }

}