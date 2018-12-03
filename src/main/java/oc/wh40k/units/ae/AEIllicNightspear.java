package oc.wh40k.units.ae;

import oc.Eintrag;

public class AEIllicNightspear extends Eintrag {

    public AEIllicNightspear() {
        name = "Illic Nightspear";
        grundkosten = getPts("Illic Nightspear");
        power = 4;
        
        seperator();

        addWarlordTraits("Alaitoc: Puritanical Leader", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}