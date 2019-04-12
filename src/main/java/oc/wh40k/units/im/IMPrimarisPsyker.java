package oc.wh40k.units.im;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PRIMARIS_PSYKER;
import static oc.KeyWord.PSYKER;

import oc.Eintrag;

public class IMPrimarisPsyker extends Eintrag {

    public IMPrimarisPsyker() {
    	super(CHARACTER, INFANTRY, PSYKER, PRIMARIS_PSYKER);

        name = "Primaris Psyker";
        grundkosten = getPts("Primaris Psyker") + getPts("Laspistol") + getPts("Force stave");
        power = 2;

        seperator();

        addWeapons(IMAstraMilitarumRuestkammer.class, true);

        seperator();

		addWarlordTraits("");

        complete();
    }
}