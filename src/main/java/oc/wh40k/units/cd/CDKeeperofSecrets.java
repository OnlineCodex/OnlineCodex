package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDKeeperofSecrets extends Eintrag {

    public CDKeeperofSecrets() {

        name = "Keeper of Secrets";
        grundkosten = getPts("Keeper of Secrets");
        power = 11;
        complete();

    }

    @Override
    public void refreshen() {
    }
}
