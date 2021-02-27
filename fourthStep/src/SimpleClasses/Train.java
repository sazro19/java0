package SimpleClasses;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Train {

    private String finalPoint;

    private int trainNumber;

    private Date startDate;

    public Train(String finalPoint, int trainNumber, Date startDate) {
        this.finalPoint = finalPoint;
        this.trainNumber = trainNumber;
        this.startDate = startDate;
    }

    public static void sortByNumber(List<Train> trains) {
        trains.sort(Comparator.comparing(Train::getTrainNumber));
        for (Train train : trains) {
            train.printInfo();
            System.out.println("");
        }
    }

    public static void printInfo(List<Train> trains) {
        int number = new Scanner(System.in).nextInt();
        for (Train train : trains) {
            if (train.getTrainNumber() == number) {
                train.printInfo();
            }
        }
    }

    public static void sortByFinalPoint(List<Train> trains) {
        for (int i = 0; i < trains.size(); i++) {
            for (int j = 0; j < trains.size() - 1; j++) {
                if (trains.get(j).getFinalPoint().equals(trains.get(j + 1).getFinalPoint())) {
                    if (trains.get(j).getStartDate().after(trains.get(j + 1).getStartDate())) {
                        Train temp = trains.get(j);
                        trains.set(j, trains.get(j + 1));
                        trains.set(j + 1, temp);
                    }
                } else {
                    for (int k = 0; k < trains.get(j).getFinalPoint().length(); k++) {
                        if (trains.get(j).getFinalPoint().charAt(k) > trains.get(j + 1).getFinalPoint().charAt(k)) {
                            Train temp = trains.get(j);
                            trains.set(j, trains.get(j + 1));
                            trains.set(j + 1, temp);
                            break;
                        } else if (trains.get(j).getFinalPoint().charAt(k) < trains.get(j + 1).getFinalPoint().charAt(k)) {
                            break;
                        }
                    }
                }
            }
        }
        for (Train train : trains) {
            train.printInfo();
            System.out.println("");
        }
    }

    private void printInfo() {
        System.out.println("Final point: " + finalPoint);
        System.out.println("Train's number: " + trainNumber);
        System.out.println("Date: " + startDate);
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getFinalPoint() {
        return finalPoint;
    }

    public Date getStartDate() {
        return startDate;
    }
}
