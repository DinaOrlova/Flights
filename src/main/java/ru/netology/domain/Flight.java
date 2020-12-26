package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flight implements Comparable {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int travelTime;

    @Override
    public int compareTo(Object o) {
        Flight flight = (Flight) o;
        return cost - flight.cost;
    }
}
