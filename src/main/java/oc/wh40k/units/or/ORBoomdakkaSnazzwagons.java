package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.Eintrag;

public class ORBoomdakkaSnazzwagons extends Eintrag {

    private final AnzahlPanel buggies;

    public ORBoomdakkaSnazzwagons() {
        grundkosten = 0;

        buggies = new AnzahlPanel(ID, randAbstand, cnt, "Boomdakka Snazzwagon", "Boomdakka Snazzwagons", 1, 3, getPts("Boomdakka Snazzwagons") + getPts("Big shoota"));
        add(buggies);

        complete();
    }

    @Override
    public void refreshen() {
        power = buggies.getModelle() * 5;
    }
}
