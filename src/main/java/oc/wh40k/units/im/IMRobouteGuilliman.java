package oc.wh40k.units.im;

import oc.Eintrag;

public class IMRobouteGuilliman extends Eintrag {

    public IMRobouteGuilliman() {
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
