package simple.airline;

import java.util.Date;
import java.util.List;

public class Airline {

    private String finalPoint;

    private int flightNumber;

    private String airplaneType;

    private Date startDate;

    private List<Day> days;

    public Airline(String finalPoint, int flightNumber, String airplaneType, Date startDate, List<Day> days) {
        this.finalPoint = finalPoint;
        this.flightNumber = flightNumber;
        this.airplaneType = airplaneType;
        this.startDate = startDate;
        this.days = days;
    }

    public String getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(String finalPoint) {
        this.finalPoint = finalPoint;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }


    @Override
    public String toString() {
        return "Airline{" +
                "finalPoint='" + finalPoint + '\'' +
                ", flightNumber=" + flightNumber +
                ", airplaneType='" + airplaneType + '\'' +
                ", startDate=" + startDate +
                ", days=" + days +
                '}';
    }
}
