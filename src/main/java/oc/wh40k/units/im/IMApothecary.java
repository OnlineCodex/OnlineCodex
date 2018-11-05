package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMApothecary extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMApothecary() {
        name = "Apothecary";
        grundkosten = getPts("Apothecary") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Chainsword (SM)") +
                getPts("Bolt pistol (SM)");
        power = 3;

        complete();
    }

    @Override
    public void refreshen() {
    }
}
