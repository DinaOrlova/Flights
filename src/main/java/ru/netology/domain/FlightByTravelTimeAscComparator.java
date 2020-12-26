package ru.netology.domain;

import java.util.Comparator;

public class FlightByTravelTimeAscComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
