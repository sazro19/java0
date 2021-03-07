package association.bank;

import java.util.*;

// TODO: 07.03.2021 sums, sorts??, sums pos ane neg

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
            if (isClientExists(cl)) {
                System.out.println(Messages.CLIENT_IS_ALREADY_EXISTS_MESSAGE.getMessage());
            } else {
                this.getClients().put(cl.getId(), cl);
            }
        }
    }

    void openNewAccount(Client client) {
        if (!isClientExists(client)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else {
            BankAccount newAcc = newAccount(client);
            client.getBankAccounts().put(newAcc.getId(), newAcc);
        }
    }

    void blockAccount(Client client, BankAccount account) {
        if (!isClientExists(client)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else if (!isAccountExists(client, account)) {
            System.out.println(Messages.ACCOUNT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else {
            account.setActive(false);
        }
    }

    void unblockAccount(Client client, BankAccount account) {
        if (!isClientExists(client)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else if (!isAccountExists(client, account)) {
            System.out.println(Messages.ACCOUNT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else {
            account.setActive(true);
        }
    }

    BankAccount findBankAccount(Client client, BankAccount account) {
        if (!isClientExists(client)) {
            System.out.println(Messages.CLIENT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else if (!isAccountExists(client, account)) {
            System.out.println(Messages.ACCOUNT_IS_NOT_EXISTING_MESSAGE.getMessage());
        } else {
            return client.getBankAccounts().get(account.getId());
        }
        return null;
    }

    private BankAccount newAccount(Client client) {
        Random random = new Random();
        int id = random.nextInt(1000001) + 1;
        while (this.getClients().get(client.getId()).getBankAccounts().containsKey(id)) {
            id = random.nextInt(1000001) + 1;
        }
        return new BankAccount(id, 0);
    }

    private boolean isClientExists(Client client) {
        return this.getClients().containsKey(client.getId());
    }

    private boolean isAccountExists(Client client, BankAccount bankAccount) {
        return this.getClients().get(client.getId()).getBankAccounts().containsKey(bankAccount.getId());
    }
}
