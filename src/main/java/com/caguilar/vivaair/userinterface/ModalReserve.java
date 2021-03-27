package com.caguilar.vivaair.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ModalReserve extends PageObject {
        public static final Target SPAN_NO_THANKS = Target.the("modal option no thanks")
                        .locatedBy("//span[contains(text(),'No, gracias')]");
        public static final Target BTN_NO_THANKS = Target.the("btn confirm not thaks")
                        .locatedBy("//div[@class='vue-dialog-buttons']/button[1]");
}
