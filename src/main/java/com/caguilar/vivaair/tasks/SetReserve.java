package com.caguilar.vivaair.tasks;

import java.util.List;
import java.util.Map;

import com.caguilar.vivaair.interactions.TurnOffSwitch;
import com.caguilar.vivaair.userinterface.FlightsList;
import com.caguilar.vivaair.userinterface.ModalReserve;
import com.caguilar.vivaair.userinterface.SummaryReserve;
import com.caguilar.vivaair.util.FlightUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

@AllArgsConstructor
@Setter
@Getter
public class SetReserve implements Task {

    private FlightsList flightList;
    private ModalReserve modalReserve;
    private SummaryReserve summaryReserve;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<WebElementFacade, Integer> auxMapWebElement = cheapestFlight();
        WebElementFacade cheapestFlight = (WebElementFacade) auxMapWebElement.keySet().toArray()[0];
        Integer initialPrice = auxMapWebElement.get(cheapestFlight);

        actor.remember("initialPrice", initialPrice);

        actor.attemptsTo(Click.on(cheapestFlight), Click.on(FlightsList.BUY_DEMAND),
                JavaScriptClick.on(FlightsList.CONTINUE));

        actor.attemptsTo(WaitUntil.the(ModalReserve.SPAN_NO_THANKS, WebElementStateMatchers.isClickable()),
                JavaScriptClick.on(ModalReserve.SPAN_NO_THANKS), Click.on(ModalReserve.BTN_NO_THANKS),
                JavaScriptClick.on(ModalReserve.SPAN_NO_THANKS),
                WaitUntil.the(SummaryReserve.CHECK_BOX, WebElementStateMatchers.isClickable()),
                JavaScriptClick.on(SummaryReserve.CHECK_BOX), new TurnOffSwitch(summaryReserve.switchButton()));

    }

    public static SetReserve selectTheCheapest(FlightsList flightList, ModalReserve modalReserve,
            SummaryReserve summaryReserve) {
        return Tasks.instrumented(SetReserve.class, flightList, modalReserve, summaryReserve);
    }

    private Map<WebElementFacade, Integer> cheapestFlight() {

        List<WebElementFacade> flights = flightList.getFlight();
        Map<WebElementFacade, Integer> auxLowerPrice = FlightUtil.lowerPrice(flights);
        return auxLowerPrice;

    }

}