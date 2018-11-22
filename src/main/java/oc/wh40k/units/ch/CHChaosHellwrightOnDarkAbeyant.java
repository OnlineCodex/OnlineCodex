package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHChaosHellwrightOnDarkAbeyant extends Eintrag {

    public CHChaosHellwrightOnDarkAbeyant() {

        name = "Chaos Hellwright on Dark Abeyant";
        grundkosten = getPts("Chaos Hellwright on Dark Abeyant") +
        			  getPts("infernal axe") +
        			  getPts("mechatendrils") +
        			  getPts("voidcutter") +
        			  getPts("flamer") +
        			  getPts("soulburner pistol") +
        			  getPts("warpfire lance");
        power = 9;

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
