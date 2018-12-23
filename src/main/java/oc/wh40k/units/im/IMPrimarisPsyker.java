package oc.wh40k.units.im;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.PSYKANA;

public class IMPrimarisPsyker extends Eintrag {

    private final RuestkammerStarter psychicPowers;

    public IMPrimarisPsyker() {
        name = "Primaris Psyker";
        grundkosten = getPts("Primaris Psyker") + getPts("Laspistol") + getPts("Force stave");
        power = 2;

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, PSYKANA), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );

    }
}