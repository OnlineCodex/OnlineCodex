package oc.wh40k.units.im;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMMISSAR;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.LORD_COMMISSAR;

import oc.Eintrag;

public class IMLordCommissar extends Eintrag {

    public IMLordCommissar() {
    	super(CHARACTER, INFANTRY, COMMISSAR, LORD_COMMISSAR);

        name = "Lord Commissar";
        grundkosten = getPts("Lord Commissar");
        power = 4;

        seperator();

        addWeapons(IMAstraMilitarumRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}