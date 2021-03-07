package association.bank;

public enum Messages {

    CLIENT_IS_NOT_EXISTING_MESSAGE("Client is not existing"),

    ACCOUNT_IS_NOT_EXISTING_MESSAGE("Account is not existing"),

    CLIENT_IS_ALREADY_EXISTS_MESSAGE("Client is already exists"),

    ACCOUNT_IS_BLOCKED("Account is blocked");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String  getMessage() {
        return this.message;
    }
}
