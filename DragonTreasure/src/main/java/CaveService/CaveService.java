package CaveService;

import Treasure.Jewel;

import java.util.List;

public interface CaveService {

    List<Jewel> getAllJewels();

    Jewel getMostExpensive();

    List<Jewel> getOnSum(double sum);
}
