package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.domain.FlightByTravelTimeAscComparator;
import ru.netology.repository.FlightRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightRepository repository = new FlightRepository();
    private FlightManager manager = new FlightManager(repository);
    private Flight RHO1 = new Flight(1, 2000, "GOJ", "RHO", 240);
    private Flight RHO2 = new Flight(2, 1500, "GOJ", "RHO", 240);
    private Flight RHO3 = new Flight(3, 1500, "GOJ", "RHO", 300);
    private Flight RHO4 = new Flight(4, 2500, "GOJ", "RHO", 240);
    private Flight RHO5 = new Flight(5, 1200, "GOJ", "RHO", 350);
    private Flight GOJ1 = new Flight(6, 2000, "RHO", "GOJ", 240);
    private Flight FCO1 = new Flight(7, 3500, "GOJ", "FCO", 400);
    private Flight FCO2 = new Flight(8, 2500, "SVO", "FCO", 200);

    @BeforeEach
    public void setUp() {
        repository.addFlight(RHO1);
        repository.addFlight(RHO2);
        repository.addFlight(RHO3);
        repository.addFlight(RHO4);
        repository.addFlight(RHO5);
        repository.addFlight(GOJ1);
        repository.addFlight(FCO1);
        repository.addFlight(FCO2);
    }

    @Test
    void shouldSearchMultipleFlightsSortedByPrice() {
        String from = "GOJ";
        String to = "RHO";

        Flight[] actual = manager.searchFlight(from, to);
        Flight[] expected = new Flight[]{RHO5, RHO2, RHO3, RHO1, RHO4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOneFlightSortedByPrice() {
        String from = "GOJ";
        String to = "FCO";

        Flight[] actual = manager.searchFlight(from, to);
        Flight[] expected = new Flight[]{FCO1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchFlightSortedByPrice() {
        String from = "GOJ";
        String to = "SVO";

        Flight[] actual = manager.searchFlight(from, to);
        Flight[] expected = new Flight[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchMultipleFlightsSortedByTravelTime() {
        String from = "GOJ";
        String to = "RHO";
        FlightByTravelTimeAscComparator timeComparator = new FlightByTravelTimeAscComparator();

        Flight[] actual = manager.searchFlight(from, to, timeComparator);
        Flight[] expected = new Flight[]{RHO1, RHO2, RHO4, RHO3, RHO5};

        assertArrayEquals(expected, actual);
    }
}