package com.caguilar.vivaair.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.serenitybdd.core.pages.WebElementFacade;

public class FlightUtil {

    public static Map<WebElementFacade, Integer> lowerPrice(List<WebElementFacade> flights) {
        WebElementFacade lowerFlight = null;
        int minVal = Integer.MAX_VALUE;

        for (WebElementFacade e : flights) {
            int currentPrice = PriceUtil.castPrice(e.getText());

            if (currentPrice < minVal) {
                minVal = currentPrice;
                lowerFlight = e;
            }
        }
        Map<WebElementFacade, Integer> mapa = new HashMap<>();
        mapa.put(lowerFlight, minVal);
        return mapa;
    }
}