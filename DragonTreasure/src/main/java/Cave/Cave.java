package Cave;

import Dragon.Dragon;
import Treasure.Jewel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            jewelList.add(new Jewel(args[0], Double.parseDouble(args[1])));
            count++;
        }
    }
}
