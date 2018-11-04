package oc.wh40k.units.fo;

import oc.Eintrag;

public class FOTidewallShieldline extends Eintrag {


    public FOTidewallShieldline() {
        name = "Tidewall Shieldline";
        grundkosten = 60;

        complete();
    }

    @Override
    public void refreshen() {
    }
}
