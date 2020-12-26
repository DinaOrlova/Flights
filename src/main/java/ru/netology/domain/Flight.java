package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flight implements Comparable<Flight> {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int travelTime;

    @Override
    public int compareTo(Flight o) {
        return cost - o.cost;
    }
}
