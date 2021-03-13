package payment;

import java.util.List;

public class Payment {

    private Purchase purchase;

    private double payment;

    public Payment(List<Product> productList) {
        PurchaseCreator creator = new PurchaseCreator(productList);
        payment = purchase.calcPrice();
    }

    public class PurchaseCreator {

        PurchaseCreator(List<Product> productList) {
            purchase = new Purchase(productList);
        }
    }
}
