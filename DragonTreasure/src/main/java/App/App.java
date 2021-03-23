package App;

import CaveService.*;
import Dragon.RedDragon;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        CaveService service = new CommonCaveService(new RedDragon("Red", 10), "jewels");
        while (true) {
            System.out.println("""
                    1 - print all jewels
                    2 - print most expensive jewel
                    3 - jewel on sum
                    4 - exit
                    """);
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> System.out.println(service.getAllJewels());
                case 2 -> System.out.println(service.getMostExpensive());
                case 3 -> {
                    System.out.println("Enter sum");
                    System.out.println(service.getOnSum(new Scanner(System.in).nextDouble()));
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Choose option from 1 to 3!");
            }
        }
    }
}
