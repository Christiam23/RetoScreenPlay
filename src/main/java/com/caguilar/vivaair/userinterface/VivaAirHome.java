package com.caguilar.vivaair.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class VivaAirHome extends PageObject {
    public static final Target ONE_WAY = Target.the("One way flight checkbox").locatedBy("//span[contains(text(),'Solo ida')]");
    public static final Target ORIGIN = Target.the("input city origin").locatedBy("//input[@id='criteria-airport-select-departure-input']");
    public static final Target DESTINATION = Target.the("input city destination").locatedBy("//input[@id='criteria-airport-select-destination-input']");
    public static final Target DATE_GONE = Target.the("Date gone").located(By.id("criteria-dates-from"));
    public static final Target BTN_SEARCH_FLIGHTS = Target.the("Button search flights").locatedBy("//button[@id='criteria-search-button-desktop']");
    public static final Target DATE = Target.the("Date Flight").locatedBy("//button[@date='{0}']");
}
