package com.caguilar.vivaair.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static com.caguilar.vivaair.model.FlightBuilder.*;
import static com.caguilar.vivaair.questions.ComparePrice.checkFinalPrice;

import com.caguilar.vivaair.tasks.SearchFlight;
import com.caguilar.vivaair.tasks.SetReserve;
import com.caguilar.vivaair.userinterface.FlightsList;
import com.caguilar.vivaair.userinterface.ModalReserve;
import com.caguilar.vivaair.userinterface.SummaryReserve;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class BookFlightStepDefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) wants to book a flight with vivaair$")
    public void goToVivaAir(String actorName) {
        theActorCalled(actorName).wasAbleTo(Open.url("https://www.vivaair.com/co/es"));
    }

    @When("^Cristian books the cheapest flight from Medellin to Bogota$")
    public void getCheapestFlight() {
        theActorInTheSpotlight().attemptsTo(
                SearchFlight.withThisData(from("Medellin").to("Bogota").oneWay().forTomorrow()),
                SetReserve.selectTheCheapest(new FlightsList(), new ModalReserve(), new SummaryReserve()));
    }

    @Then("^Cristian verifies that the value of the initial flight is equal to the end$")
    public void checkPrice() {
        theActorInTheSpotlight().should(seeThat(checkFinalPrice()));

    }
}
