package com.caguilar.vivaair.questions;

import com.caguilar.vivaair.userinterface.SummaryReserve;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ComparePrice implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        Integer initPrice = actor.recall("initialPrice");
        String price = SummaryReserve.FINAL_PRICE.resolveFor(actor).getText();
        String priceFinal = "";
        char[] arrayChar = price.toCharArray();
        for (char ch : arrayChar) {
            if (Character.isDigit(ch)) {
                priceFinal += ch;
            }
        }

        if (priceFinal.equalsIgnoreCase(initPrice.toString())) {
            return true;
        }

        return false;

    }

    public static Question<Boolean> checkFinalPrice() {
        return new ComparePrice();
    }

}