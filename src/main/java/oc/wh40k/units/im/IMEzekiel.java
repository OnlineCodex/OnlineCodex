package oc.wh40k.units.im;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.INTERROMANCY;

public class IMEzekiel extends Eintrag {

    private final RuestkammerStarter psychicPowers;

    public IMEzekiel() {
        name = "Ezekiel";
        grundkosten = getPts("Ezekiel");
        power = 7;

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(3, INTERROMANCY), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

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

