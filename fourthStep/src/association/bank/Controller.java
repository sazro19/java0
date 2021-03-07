package association.bank;

public class Controller {

    private final Bank bank;

    public Controller(Bank bank) {
        this.bank = bank;
    }

    public void addClients(Client... clients) {
        bank.addClients(clients);
    }

    public void openNewAccount(Client client) {
        bank.openNewAccount(client);
    }

    public void blockAccount(Client client, BankAccount account) {
        bank.blockAccount(client, account);
    }

    public void unblockAccount(Client client, BankAccount account) {
        bank.unblockAccount(client, account);
    }

    public BankAccount findAccount(Client client, BankAccount account) {
        return bank.findBankAccount(client, account);
    }


}
