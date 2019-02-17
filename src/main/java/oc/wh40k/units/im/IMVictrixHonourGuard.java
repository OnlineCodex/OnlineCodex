package oc.wh40k.units.im;

import oc.Eintrag;

public class IMVictrixHonourGuard extends Eintrag {

    public IMVictrixHonourGuard() {
        name = "Honour Guard";
        grundkosten = getPts("Victrix Honour Guard") * 2 +
                getPts("Frag grenade (SM)") * 2 +
                getPts("Krak grenade (SM)") * 2 +
                getPts("Power sword (SM)") * 2 +
                getPts("Storm shield (SM)") * 2;
        power = 2;

        complete();
    }
}
