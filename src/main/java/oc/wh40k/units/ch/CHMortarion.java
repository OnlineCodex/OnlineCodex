package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CONTAGION;

public class CHMortarion extends Eintrag {

    private final RuestkammerStarter psychicPowers;

    public CHMortarion() {

        name = "Mortarion";
        grundkosten = getPts("Mortarion");
        power = 24;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(3, CONTAGION), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

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
