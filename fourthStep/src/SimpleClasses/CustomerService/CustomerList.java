package SimpleClasses.CustomerService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerList {

    private List<Customer> customerList;

    public CustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void printCustomersByAlphabet() {
        List<Customer> sorted = customerList;
        sorted.sort(Comparator.comparing(Customer::getLastname));
        printCustomerList(sorted);
    }

    public void printCustomersInCardInterval(int from, int to) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getCreditCardNumber() >= from && customer.getCreditCardNumber() <= to) {
                result.add(customer);
            }
        }
        printCustomerList(result);
    }

    public void printCustomerList() {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    public void printCustomersIdAndAllNames() {
        for (Customer customer : customerList) {
            System.out.println(customer.getId() + ": " + customer.getLastname() + " "
                    + customer.getName() + " " + customer.getPatronymic());
        }
    }

    public void printCustomerByID(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                System.out.println(customer.toString());
            }
        }
    }

    public void printIdByCustomer(Customer customer) {
        if (customerList.contains(customer)) {
            System.out.println(customerList.get(customerList.indexOf(customer)).getId());
        }
    }

    private void printCustomerList(List<Customer> customerList) {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }
}
