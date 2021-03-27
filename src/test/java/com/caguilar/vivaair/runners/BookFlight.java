package com.caguilar.vivaair.runners;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/book_flight.feature"},
        glue = {"com.caguilar.vivaair.stepdefinitions"}
)
public class BookFlight {

}
