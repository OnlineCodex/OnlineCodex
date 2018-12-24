package oc.wh40k.units.ae;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.RUNES_OF_BATTLE;

public class AESpiritseer extends Eintrag {

    public AESpiritseer() {
        name = "Spiritseer";
        grundkosten = getPts("Spiritseer") + getPts("Shuriken pistol") + getPts("Witch staff");
        power = 4;

        addPsychicPowers(1, RUNES_OF_BATTLE);

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