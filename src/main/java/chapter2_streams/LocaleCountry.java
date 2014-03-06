package chapter2_streams;

/**
 * @author Tomasz Lelek
 * @since 2014-03-05
 */
public class LocaleCountry {
    private String displayLanguage;

    public LocaleCountry(String displayCountry, String displayLanguage) {
        this.displayCountry = displayCountry;
        this.displayLanguage = displayLanguage;

    }

    public void setDisplayLanguage(String displayLanguage) {
        this.displayLanguage = displayLanguage;
    }

    public void setDisplayCountry(String displayCountry) {
        this.displayCountry = displayCountry;
    }

    public String getDisplayCountry() {

        return displayCountry;
    }

    public String getDisplayLanguage() {

        return displayLanguage;
    }

    private String displayCountry;
}
