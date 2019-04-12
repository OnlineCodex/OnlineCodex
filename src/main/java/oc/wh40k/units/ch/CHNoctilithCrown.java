package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHNoctilithCrown extends Eintrag {

    public CHNoctilithCrown() {

        category = 1;

        name = "Noctilith Crown";
        grundkosten = getPts("Noctilith Crown");

        power = 5;

        complete();
    }


    @Override
    public void refreshen() {

    }
}
