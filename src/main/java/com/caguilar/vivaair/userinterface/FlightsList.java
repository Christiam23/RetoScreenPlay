package com.caguilar.vivaair.userinterface;

import java.util.List;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class FlightsList extends PageObject {

    public final static Target BUY_DEMAND = Target.the("buy on demand")
            .locatedBy("//div[contains(text(),'Comprar A la carta')]");
    public final static Target CONTINUE = Target.the("Continue with selected combo")
            .locatedBy("//span[contains(text(),'Continuar')]");

    public List<WebElementFacade> getFlight() {
        return findAll("//div[@class='from-price']");
    }
}