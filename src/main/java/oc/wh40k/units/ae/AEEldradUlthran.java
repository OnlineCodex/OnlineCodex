package oc.wh40k.units.ae;

import oc.Eintrag;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.RUNES_OF_FATE;

public class AEEldradUlthran extends Eintrag {

    public AEEldradUlthran() {
        name = "Eldrad Ulthran";
        grundkosten = getPts("Eldrad Ulthran");
        power = 9;

        addPsychicPowers(3, RUNES_OF_FATE);

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