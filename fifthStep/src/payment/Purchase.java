package payment;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private List<Product> productList = new ArrayList<>();

    Purchase(List<Product> productList) {
        this.productList = productList;
    }

    double calcPrice() {
        double sum = 0;
        for (Product product : productList) {
            sum += product.getPrice();
        }
        return sum;
    }
}
