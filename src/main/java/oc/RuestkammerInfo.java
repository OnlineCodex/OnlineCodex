package oc;

public class RuestkammerInfo {


    String kammerName;

    String text;

    int einrückIndex;

    int grundkosten;

    boolean[] defaults;


    public RuestkammerInfo(String kammerName, String text, int grundkosten, boolean[] defaults) {

        this.kammerName = kammerName;

        this.text = text;

        this.grundkosten = grundkosten;

        this.defaults = defaults;

    }


    public RuestkammerInfo(String kammerName, String text, int einrückIndex, int grundkosten, boolean[] defaults) {

        this.kammerName = kammerName;

        this.text = text;

        this.einrückIndex = einrückIndex;

        this.grundkosten = grundkosten;

        this.defaults = defaults;

    }


}