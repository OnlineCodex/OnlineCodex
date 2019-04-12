package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.ASURYANI;
import static oc.KeyWord.AUTARCH;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class AEAutarch extends Eintrag {

    public AEAutarch() {
       	super(AELDARI, ASURYANI, CHARACTER, INFANTRY, AUTARCH);

        name = "Autarch";
        grundkosten = getPts("Autarch") + getPts("Plasma grenades") + getPts("Forceshield");
        power = 4;

        seperator();

        addWeapons(AECraftworldRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}