package oc.wh40k.units.im;

import oc.Eintrag;

public class IMImperialSpaceMarine extends Eintrag {

    public IMImperialSpaceMarine() {
        name = "Imperial Space Marine";
        grundkosten = getPts("Imperial Space Marine") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("disintegration combi-gun") +
                getPts("disintegration pistol,");
        power = 3;

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
