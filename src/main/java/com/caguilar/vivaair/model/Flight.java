package com.caguilar.vivaair.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {

    private String origin;
    private String destination;
    private Boolean oneWay;
    private String dateGone;

}
