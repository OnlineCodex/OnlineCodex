package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CONTAGION;

public class CHMortarion extends Eintrag {

    public CHMortarion() {

        name = "Mortarion";
        grundkosten = getPts("Mortarion");
        power = 24;

        seperator();

        addPsychicPowers(3, CONTAGION);

        seperator();
        
        addWarlordTraits("Arch-Contaminator", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
