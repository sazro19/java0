package association.bank;

import java.util.List;

public class Controller {

    private final Bank bank;

    public Controller(Bank bank) {
        this.bank = bank;
    }

    public void addClients(Client... clients) {
        bank.addClients(clients);
    }

    public void openNewAccount(Integer clientId) {
        bank.openNewAccount(clientId);
    }

    public void blockAccount(Integer clientId, Integer accountId) {
        bank.blockAccount(clientId, accountId);
    }

    public void unblockAccount(Integer clientId, Integer accountId) {
        bank.unblockAccount(clientId, accountId);
    }

    void upBalance(Integer clientId, Integer accountId, double sum) {
        bank.upBalance(clientId, accountId, sum);
    }

    public BankAccount findAccount(Integer clientId, Integer accountId) {
        return bank.findBankAccount(clientId, accountId);
    }

    public List<BankAccount> findSortedAccounts(Integer clientId) {
        return bank.SortBankAccounts(clientId);
    }

    public double sumOnPosAcc(Integer clientId) {
        return bank.sumOnPosAcc(clientId);
    }

    public double sumOnNegAcc(Integer clientId) {
        return bank.sumOnNegAcc(clientId);
    }

    public static void main(String[] args) {
        Controller controller = new Controller(new Bank("Bel"));
        controller.addClients(new Client(1, "a", "b", "c"),
                new Client(2, "z", "x", "c"));
        controller.openNewAccount(1);
        controller.openNewAccount(2);
        controller.openNewAccount(1);
        controller.openNewAccount(2);
        List<BankAccount> list = controller.findSortedAccounts(1);
        controller.upBalance(1, controller.findSortedAccounts(1).get(0).getId(), 50);
        controller.upBalance(1, controller.findSortedAccounts(1).get(0).getId(), 58);
        controller.upBalance(2, controller.findSortedAccounts(2).get(0).getId(), -58);
        controller.upBalance(2, controller.findSortedAccounts(2).get(1).getId(), -50);
        System.out.println(controller.sumOnPosAcc(1));
        System.out.println(controller.sumOnNegAcc(2));
        controller.blockAccount(1, controller.findSortedAccounts(1).get(0).getId());
        controller.upBalance(1, controller.findSortedAccounts(1).get(0).getId(), 50);

    }

}
