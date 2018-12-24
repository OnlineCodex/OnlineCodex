package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CONTAGION;

public class CHTyphus extends Eintrag {

    public CHTyphus() {
        name = "Typhus";
        grundkosten = getPts("Typhus");
        power = 9;

        addPsychicPowers(2, CONTAGION);

        seperator();
        
        addWarlordTraits("Living Plague", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
