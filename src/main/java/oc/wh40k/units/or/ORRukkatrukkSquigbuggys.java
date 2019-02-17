package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.Eintrag;

public class ORRukkatrukkSquigbuggys extends Eintrag {

	private final AnzahlPanel buggies;

    public ORRukkatrukkSquigbuggys() {

        kategorie = 4;
        grundkosten = 0;

        buggies = new AnzahlPanel(ID, randAbstand, cnt, "Rukkatrukk Squigbuggy", "Rukkatrukk Squigbuggies", 1, 3, getPts("Rukkatrukk Squigbuggies"));
        add(buggies);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        power = buggies.getModelle() * 7;
    }
}
