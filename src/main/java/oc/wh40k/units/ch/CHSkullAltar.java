package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHSkullAltar extends Eintrag {

    public CHSkullAltar() {

        kategorie = 1;

        name = "Skull Altar";
        grundkosten = getPts("Skull Altar");

        power = 5;

        complete();
    }


    @Override
    public void refreshen() {

    }
}
