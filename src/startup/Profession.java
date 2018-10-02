package startup;

public enum  Profession {
    Manager("M"), Worker("W"), Boss("B"), Cleaner("C");
    private String abbr;
    Profession(String s)
    {
        this.abbr = s;
    }

    public String getAbbr() {
        return abbr;
    }
}
