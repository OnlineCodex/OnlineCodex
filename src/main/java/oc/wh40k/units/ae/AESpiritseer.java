package oc.wh40k.units.ae;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.RUNES_OF_BATTLE;

public class AESpiritseer extends Eintrag {

    private final RuestkammerStarter psychicPowers;

    public AESpiritseer() {
        name = "Spiritseer";
        grundkosten = getPts("Spiritseer") + getPts("Shuriken pistol") + getPts("Witch staff");
        power = 4;

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, RUNES_OF_BATTLE), "Psychic Powers");
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