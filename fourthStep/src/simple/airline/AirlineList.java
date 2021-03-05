package simple.airline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirlineList {

    private List<Airline> airlineList;

    public AirlineList(List<Airline> airlineList) {
        this.airlineList = airlineList;
    }

    public void printAirlineList() {
        for (Airline airline : airlineList) {
            System.out.println(airline.toString());
        }
    }

    public void printAirlineListByFinalPoint(String point) {
        List<Airline> result = new ArrayList<>();
        for (Airline airline : airlineList) {
            if (airline.getFinalPoint().equals(point)) {
                result.add(airline);
            }
        }
        printAirlineList(result);
    }

    public void printAirlineListByDay(Day day) {
        List<Airline> result = new ArrayList<>();
        for (Airline airline : airlineList) {
            if (airline.getDays().contains(day)) {
                result.add(airline);
            }
        }
        printAirlineList(result);
    }

    public void printAirlineListByDayAndTime(Day day, Date date) {
        List<Airline> result = new ArrayList<>();
        for (Airline airline : airlineList) {
            if (airline.getDays().contains(day)) {
                if (airline.getStartDate().after(date)) {
                    result.add(airline);
                }
            }
        }
        printAirlineList(result);
    }

    public void printFlightNumbers() {
        for (Airline airline : airlineList) {
            System.out.println(airline.getFlightNumber());
        }
    }

    private void printAirlineList(List<Airline> airlineList) {
        for (Airline airline : airlineList) {
            System.out.println(airline.toString());
        }
    }
}
