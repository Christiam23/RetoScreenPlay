package com.caguilar.vivaair.model;

import com.caguilar.vivaair.util.DateUtil;

public class FlightBuilder {

    private Flight flight;

    public FlightBuilder(String from) {
        this.flight = new Flight();
        flight.setOrigin(from);
        flight.setOneWay(false);
    }

    public static FlightBuilder from(String from) {
        return new FlightBuilder(from);
    }

    public FlightBuilder to(String to) {
        flight.setDestination(to);
        return this;
    }

    public FlightBuilder oneWay() {
        flight.setOneWay(true);
        return this;
    }

    public Flight forTomorrow() {
        flight.setDateGone(DateUtil.dateTomorrow());
        return flight;
    }

}
