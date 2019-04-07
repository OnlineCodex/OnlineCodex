package oc;

public class OptionsGruppeEintrag implements Comparable<OptionsGruppeEintrag> {

    String name;
    String kurzerName = null;
    double preis;
    double syncPreis;
    boolean unique = false; //Darf in der Armee nur einmal vorkommen
    boolean relic = false; //Darf in der Armee nur einmal vorkommen und zählt gegen die Gesamtzahl erlaubter Relikte

    public OptionsGruppeEintrag(String name) {
        this.name = name;
        this.preis = -88;
        this.syncPreis = 0;
    }

    public OptionsGruppeEintrag(String name, double preis) {
        this.name = name;
        this.preis = preis;
        this.syncPreis = 0;
    }

    public OptionsGruppeEintrag(String kurzerName, String name) {
        this.kurzerName = kurzerName;
        this.name = name;
        this.preis = -88;
        this.syncPreis = 0;
    }

    public OptionsGruppeEintrag(String name, double preis, int syncPreis) {
        this.name = name;
        this.preis = preis;
        this.syncPreis = syncPreis;
    }

    public OptionsGruppeEintrag(String kurzerName, String name, double preis) {
        this.kurzerName = kurzerName;
        this.name = name;
        this.preis = preis;
        this.syncPreis = 0;
    }

    public OptionsGruppeEintrag(String kurzerName, String name, double preis, int syncPreis) {
        this.kurzerName = kurzerName;
        this.name = name;
        this.preis = preis;
        this.syncPreis = syncPreis;
    }

    public String getName() {
        return this.name;
    }

    public String getKurzerName() {
        return this.kurzerName;
    }

    public double getPreis() {
        return this.preis;
    }

    public double getSyncPreis() {
        return this.syncPreis;
    }

    public boolean isUnique() {
        return this.unique;
    }

    public OptionsGruppeEintrag setUnique(boolean unique) {
        this.unique = unique;
        return this;
    }

    public boolean isRelic() {
        return this.unique;
    }

    public OptionsGruppeEintrag setRelic(boolean relic) {
        this.unique = relic;
        this.relic = relic;
        return this;
    }

    @Override
	public int compareTo(OptionsGruppeEintrag a) {
        return (int) (a.getPreis() - this.getPreis());

    }

}