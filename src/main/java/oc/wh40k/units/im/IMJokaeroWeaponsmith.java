package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMJokaeroWeaponsmith extends Eintrag {

    public IMJokaeroWeaponsmith() {
    	super(IMPERIUM, INQUISITION, ORDO_MALLEUS);
        name = "Jokaero Weaponsmith";
        grundkosten = getPts("Jokaero Weaponsmith");
        power = 1;

        complete();
    }

    @Override
    public void refreshen() {
    }

}
