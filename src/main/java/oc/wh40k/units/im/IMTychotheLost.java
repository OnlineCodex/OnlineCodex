package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_COMPANY;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TYCHO;

import oc.Eintrag;

public class IMTychotheLost extends Eintrag {

    public IMTychotheLost() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, DEATH_COMPANY, CHARACTER, INFANTRY, TYCHO);
        name = "Tycho the Lost";
        grundkosten = getPts("Tycho the Lost");
        power = 4;
        seperator();

        addWarlordTraits("Selfless Valour (BA)");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }

}
