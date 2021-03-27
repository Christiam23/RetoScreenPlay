package com.caguilar.vivaair.userinterface;

import java.util.List;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SummaryReserve extends PageObject {

    public final static Target CHECK_BOX = Target.the("Checkbox")
            .locatedBy("//div[@class='chubb-single-offer']/label/span[@class='box']");
    public final static Target FINAL_PRICE = Target.the("final price").locatedBy("//span[@class='price']");

    public List<WebElementFacade> switchButton() {
        return findAll(By.xpath("//label[@class='switch']"));
    }

}