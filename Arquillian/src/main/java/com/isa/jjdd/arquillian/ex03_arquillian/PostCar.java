package com.isa.jjdd.arquillian.ex03_arquillian;

import javax.inject.Inject;

public class PostCar {

    @Inject
    GasStation gasStation;

    FuelTank fuelTank = new FuelTank();

    void fillPetrol() {
        gasStation.fill(fuelTank, 100);
    }

}
