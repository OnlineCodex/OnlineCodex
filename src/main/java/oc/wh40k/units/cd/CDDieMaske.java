package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDDieMaske extends Eintrag {

    public CDDieMaske() {

        name = "Die Maske";

        grundkosten = 75;

        add(ico = new oc.Picture("oc/wh40k/images/CDDieMaske.gif"));

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
