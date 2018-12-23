package oc.wh40k.units.ae;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.RUNES_OF_FATE;

public class AEEldradUlthran extends Eintrag {

    private final RuestkammerStarter psychicPowers;

    public AEEldradUlthran() {
        name = "Eldrad Ulthran";
        grundkosten = getPts("Eldrad Ulthran");
        power = 9;

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(3, RUNES_OF_FATE), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();

        addWarlordTraits("Ulthwé: Fate Reader", true);

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