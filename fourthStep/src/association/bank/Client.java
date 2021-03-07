package association.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Client {

    private int id;

    private String firstname;

    private String lastname;

    private String patronymic;

    private Map<Integer, BankAccount> BankAccounts = new HashMap<>();

    public Client(int id, String firstname, String lastname, String patronymic) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Map<Integer, BankAccount> getBankAccounts() {
        return BankAccounts;
    }

    public void setBankAccounts(Map<Integer, BankAccount> bankAccounts) {
        BankAccounts = bankAccounts;
    }
}
