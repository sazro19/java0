package association.vaucher;

public enum Type {

    HOLIDAY("Holiday"),
    EXCURSION("Excursion"),
    TREATMENT("Treatment"),
    SHOPPING("Shopping"),
    CRUISE("Cruise");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
