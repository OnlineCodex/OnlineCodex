package oc.wh40k.units.im;

import oc.Eintrag;

public class IMDeathwatchPrimarisApothecary extends Eintrag {

    public IMDeathwatchPrimarisApothecary() {
        name = "Primaris Apothecary";
        grundkosten = getPts("Primaris Apothecary") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Absolver bolt pistol (DW)") + getPts("Reductor pistol");
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4;
    }
}
