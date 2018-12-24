package oc.wh40k.units.im;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.INTERROMANCY;

public class IMEzekiel extends Eintrag {

    public IMEzekiel() {
        name = "Ezekiel";
        grundkosten = getPts("Ezekiel");
        power = 7;

        addPsychicPowers(3, INTERROMANCY);

        seperator();

        addWarlordTraits("Courage of the First Legion (DA)", true);

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

