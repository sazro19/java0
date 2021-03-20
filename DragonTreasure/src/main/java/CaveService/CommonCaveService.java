package CaveService;

import Dragon.Dragon;
import Treasure.Jewel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommonCaveService implements CaveService {

    private Cave cave;

    public class Cave {

        private static final int MAX_JEWEL = 100;

        private final Dragon dragon;

        private final List<Jewel> jewelList = new ArrayList<>();

        public Cave(Dragon dragon, String path) {
            this.dragon = dragon;
            try {
                readJewels(path);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        private void readJewels(String path) throws IOException {
            File file = new File(path);
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            long count = 0;
            while (count <= MAX_JEWEL) {
                String line = bufferedReader.readLine();
                String[] args = line.split(" ");
                jewelList.add(new Jewel(args[0], Double.parseDouble(args[1]) * dragon.getLevel()));
                count++;
            }
        }
    }

    public CommonCaveService(Dragon dragon, String path) {
        cave = new Cave(dragon, path);
        cave.jewelList.sort(Comparator.comparing(Jewel::getCost));
    }

    @Override
    public List<Jewel> getAllJewels() {
        return cave.jewelList;
    }

    @Override
    public Jewel getMostExpensive() {
        return cave.jewelList.get(cave.jewelList.size() - 1);
    }

    @Override
    public List<Jewel> getOnSum(double sum) {
        List<Jewel> jewelsOnSum = new ArrayList<>();
        double sumCounter = 0;
        for (Jewel jewel : cave.jewelList) {
            sumCounter += jewel.getCost();
            if (sumCounter >= sum) {
                break;
            }
            jewelsOnSum.add(jewel);
        }
        return jewelsOnSum;
    }
}
