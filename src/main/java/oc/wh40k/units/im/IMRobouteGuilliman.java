package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.MONSTER;
import static oc.KeyWord.PRIMARCH;
import static oc.KeyWord.ROBOUTE_GUILLIMAN;
import static oc.KeyWord.ULTRAMARINES;

import oc.Eintrag;

public class IMRobouteGuilliman extends Eintrag {

    public IMRobouteGuilliman() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, MONSTER, PRIMARCH, ROBOUTE_GUILLIMAN);
        name = "Roboute Guilliman";
        grundkosten = getPts("Roboute Guilliman");
        power = 18;

        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }


}
