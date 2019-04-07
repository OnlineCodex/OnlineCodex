package oc.wh40k.units.im;

import static oc.KeyWord.ASTRA_MILITARUM;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMMISSAR;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class IMCommissar extends Eintrag {

    public IMCommissar() {
    	super(IMPERIUM, ASTRA_MILITARUM, INFANTRY, CHARACTER, COMMISSAR);

        name = "Commissar";
        grundkosten = getPts("Commissar");
        power = 2;

        seperator();

        addWeapons(IMAstraMilitarumRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}