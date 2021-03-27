package com.caguilar.vivaair.interactions;

import java.util.List;

import lombok.AllArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

@AllArgsConstructor
public class TurnOffSwitch implements Interaction {

    List<WebElementFacade> switchButton;

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (WebElementFacade e : switchButton) {
            actor.attemptsTo(Click.on(e));
        }

    }

}