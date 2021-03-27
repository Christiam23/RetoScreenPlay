package com.caguilar.vivaair.tasks;

import com.caguilar.vivaair.exceptions.SelectDateGone;
import com.caguilar.vivaair.model.Flight;
import com.caguilar.vivaair.userinterface.VivaAirHome;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

@AllArgsConstructor
public class SearchFlight implements Task {

    private final Flight flight;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(VivaAirHome.ONE_WAY),
                Enter.theValue(flight.getOrigin() + "\n").into(VivaAirHome.ORIGIN),
                Enter.theValue(flight.getDestination() + "\n").into(VivaAirHome.DESTINATION),
                SelectDateGone.on(flight.getDateGone()),
                Click.on(VivaAirHome.BTN_SEARCH_FLIGHTS)
        );

    }

    public static SearchFlight withThisData(Flight flight) {
        return Tasks.instrumented(SearchFlight.class, flight);
    }
}
