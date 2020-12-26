package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;
import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
public class FlightManager {
    private FlightRepository repository;

    public Flight[] searchFlight(String from, String to) {
        Flight[] result = new Flight[0];
        for (Flight flight : repository.findAll()) {
            if (flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(to)) {
                Flight[] tmp = new Flight[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flight;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Flight[] searchFlight(String from, String to, Comparator<Flight> comparator) {
        Flight[] result = new Flight[0];
        for (Flight flight : repository.findAll()) {
            if (flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(to)) {
                Flight[] tmp = new Flight[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flight;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}
