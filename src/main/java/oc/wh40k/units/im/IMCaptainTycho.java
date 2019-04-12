package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.CAPTAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TYCHO;

import oc.Eintrag;

public class IMCaptainTycho extends Eintrag {

    public IMCaptainTycho() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, CAPTAIN, TYCHO);
        name = "Captain Tycho";
        grundkosten = getPts("Captain Tycho");
        power = 5;
        seperator();

        addWarlordTraits("Selfless Valour (BA)");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }

}
