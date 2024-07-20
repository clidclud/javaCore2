package les4.first;

public enum Male {
    MALE("Кот"), FEMALE("Кошка");

    private final String russianMaleTitle;

    Male(String russianMaleTitle) {
        this.russianMaleTitle = russianMaleTitle;
    }

    public String getRussianMaleTitle() {
        return russianMaleTitle;
    }
}
