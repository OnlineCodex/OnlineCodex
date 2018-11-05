package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDTheBlueScribes extends Eintrag {

    public CDTheBlueScribes() {

        name = "The Blue Scribes";
        grundkosten = getPts("The Blue Scribes");
        power = 5;
        complete();

    }

    @Override
    public void refreshen() {
    }
}
