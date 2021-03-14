package reports;

public enum PersonAges {
    ONETOTHIRTY("1-30"),
    THIRTYTOFIFTY("30-50"),
    FIFTYPLUS("50+");

    private final String interval;

    PersonAges(String interval) {
        this.interval = interval;
    }

    public String getInterval() {
        return interval;
    }
}
