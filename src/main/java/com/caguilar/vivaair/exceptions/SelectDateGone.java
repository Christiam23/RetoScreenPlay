package com.caguilar.vivaair.exceptions;

import com.caguilar.vivaair.userinterface.VivaAirHome;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

@AllArgsConstructor
public class SelectDateGone implements Interaction {

    private String dateGone;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(VivaAirHome.DATE_GONE),
                JavaScriptClick.on(VivaAirHome.DATE.of(dateGone))
        );
    }

    public static SelectDateGone on(String dateGone){
        return new SelectDateGone(dateGone);
    }
}
