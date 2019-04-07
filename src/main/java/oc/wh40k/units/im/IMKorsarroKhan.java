package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CAPTAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.KORSARRO_KHAN;
import static oc.KeyWord.WHITE_SCARS;

import oc.Eintrag;

public class IMKorsarroKhan extends Eintrag {

    public IMKorsarroKhan() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, WHITE_SCARS,CHARACTER, INFANTRY, CAPTAIN, KORSARRO_KHAN);

        name = "Kor'sarro Khan";
        grundkosten = getPts("Kor'sarro Khan");
        power = 6;
        seperator();

        seperator();

        addWarlordTraits("White Scars: Deadly Hunter", true);

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}