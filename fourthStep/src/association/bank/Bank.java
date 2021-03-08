package association.bank;

import java.util.*;
import java.util.regex.Pattern;

public class Bank {

    private String name;

    private Map<Integer, Client> clients = new HashMap<>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Client> getClients() {
        return clients;
    }

    public void setClients(Map<Integer, Client> clients) {
        this.clients = clients;
    }

    void addClients(Client... client) {
        for (Client cl : client) {
            if (isClientExists(cl.getId())) {
                System.out.println(Messages.CLIENT_IS_ALREADY_EXISTS_MESSAGE.getMessage());
            } else {
                this.getClients().put(cl.getId(), cl);
            }
        }
    }

    void openNewAccount(Integer clientId) {
        if (!isClientExists(clientId)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else {
            BankAccount newAcc = newAccount(clientId);
            clients.get(clientId).getBankAccounts().put(newAcc.getId(), newAcc);
        }
    }

    void blockAccount(Integer clientId, Integer accountId) {
        if (!isClientExists(clientId)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else if (!isAccountExists(clientId, accountId)) {
            System.out.println(Messages.ACCOUNT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else {
            clients.get(clientId).getBankAccounts().get(accountId).setActive(false);
        }
    }

    void unblockAccount(Integer clientId, Integer accountId) {
        if (!isClientExists(clientId)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else if (!isAccountExists(clientId, accountId)) {
            System.out.println(Messages.ACCOUNT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else {
            clients.get(clientId).getBankAccounts().get(accountId).setActive(true);
        }
    }

    BankAccount findBankAccount(Integer clientId, Integer accountId) {
        if (!isClientExists(clientId)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else if (!isAccountExists(clientId, accountId)) {
            System.out.println(Messages.ACCOUNT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else {
            if (clients.get(clientId).getBankAccounts().get(accountId).isActive()) {
                return clients.get(clientId).getBankAccounts().get(accountId);
            } else {
                System.out.println(Messages.ACCOUNT_IS_BLOCKED.getMessage());
            }
        }
        return null;
    }

    List<BankAccount> SortBankAccounts(Integer clientId) {
        List<BankAccount> bankAccounts = new ArrayList<>();
        for (Map.Entry<Integer, BankAccount> account : clients.get(clientId).getBankAccounts().entrySet()) {
            if (account.getValue().isActive()) {
                bankAccounts.add(account.getValue());
            } else {
                System.out.println(account.getKey() + " " + Messages.ACCOUNT_IS_BLOCKED.getMessage());
            }
        }
        bankAccounts.sort(Comparator.comparing(BankAccount::getBalance));
        return bankAccounts;
    }

    double sumOnAllAccounts(Integer clientId) {
        if (!isClientExists(clientId)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
            return Double.MIN_VALUE;
        } else {
            double sum = 0;
            for (Map.Entry<Integer, BankAccount> account : clients.get(clientId).getBankAccounts().entrySet()) {
                if (account.getValue().isActive()) {
                    sum += account.getValue().getBalance();
                } else {
                    System.out.println(account.getKey() + " " + Messages.ACCOUNT_IS_BLOCKED.getMessage());
                }
            }
            return sum;
        }
    }

    double sumOnPosAcc(Integer clientId) {
        if (!isClientExists(clientId)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
            return Double.MIN_VALUE;
        } else {
            double sum = 0;
            for (Map.Entry<Integer, BankAccount> account : clients.get(clientId).getBankAccounts().entrySet()) {
                if (account.getValue().isActive()) {
                    if (account.getValue().getBalance() > 0) {
                        sum += account.getValue().getBalance();
                    }
                } else {
                    System.out.println(account.getKey() + " " + Messages.ACCOUNT_IS_BLOCKED.getMessage());
                }
            }
            return sum;
        }
    }

    double sumOnNegAcc(Integer clientId) {
        if (!isClientExists(clientId)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
            return Double.MIN_VALUE;
        } else {
            double sum = 0;
            for (Map.Entry<Integer, BankAccount> account : clients.get(clientId).getBankAccounts().entrySet()) {
                if (account.getValue().isActive()) {
                    if (account.getValue().getBalance() < 0) {
                        sum += account.getValue().getBalance();
                    }
                } else {
                    System.out.println(account.getKey() + " " + Messages.ACCOUNT_IS_BLOCKED.getMessage());
                }
            }
            return sum;
        }
    }

    void upBalance(Integer clientId, Integer accountId, double sum) {
        if (clients.get(clientId).getBankAccounts().get(accountId).isActive()) {
            double s = clients.get(clientId).getBankAccounts().get(accountId).getBalance();
            clients.get(clientId).getBankAccounts().get(accountId).setBalance(s + sum);
        } else {
            System.out.println(Messages.ACCOUNT_IS_BLOCKED.getMessage());
        }
    }

    private BankAccount newAccount(Integer clientId) {
        Random random = new Random();
        int id = random.nextInt(1000001) + 1;
        while (this.getClients().get(clientId).getBankAccounts().containsKey(id)) {
            id = random.nextInt(1000001) + 1;
        }
        return new BankAccount(id, 0);
    }

    private boolean isClientExists(Integer clientId) {
        return this.getClients().containsKey(clientId);
    }

    private boolean isAccountExists(Integer clientId, Integer bankAccountId) {
        return this.getClients().get(clientId).getBankAccounts().containsKey(bankAccountId);
    }
}
