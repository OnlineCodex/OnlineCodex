package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANCTIC;

public class IMLordKaldorDraigo extends Eintrag {

    public IMLordKaldorDraigo() {
        name = "Lord Kaldor Draigo";
        grundkosten = getPts("Lord Kaldor Draigo");
        power = 12;

        addPsychicPowers(2, SANCTIC);

        seperator();

        addWarlordTraits("Daemon-Slayer (GK)", true);

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
