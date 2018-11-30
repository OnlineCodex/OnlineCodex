package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMApothecaryonBike extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMApothecaryonBike() {
        name = "Apothecary on Bike";
        grundkosten = getPts("Apothecary on Bike") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Chainsword (SM)") +
                getPts("Bolt pistol (SM)") +
                getPts("Twin boltgun");
        power = 4;
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
