package oc.wh40k.units.im;

import oc.Eintrag;

public class IMRavenwingChampion extends Eintrag {

    public IMRavenwingChampion() {
        name = "Ravenwing Champion";
        grundkosten = getPts("Ravenwing Champion") + getPts("Blade of Caliban") + getPts("Bolt pistol (SM)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Plasma talon");
        power = 6;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
