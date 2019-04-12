package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHKharntheBetrayer extends Eintrag {

    public CHKharntheBetrayer() {

        name = "Kharn the Betrayer";
        grundkosten = getPts("Kharn the Betrayer");
        power = 9;

        seperator();

        addWarlordTraits("World Eaters: Slaughterborn");

        complete();

    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
