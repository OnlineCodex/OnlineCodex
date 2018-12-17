package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMRobouteGuilliman extends Eintrag {

    public IMRobouteGuilliman() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, MONSTER, PRIMARCH, ROBOUTE_GUILLIMAN);
        name = "Roboute Guilliman";
        grundkosten = getPts("Roboute Guilliman");
        power = 18;
        
        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }


}
