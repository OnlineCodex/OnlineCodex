package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANCTIC;

public class IMBrotherCaptainStern extends Eintrag {

    public IMBrotherCaptainStern() {
        name = "Brother-Captain Stern";
        grundkosten = getPts("Brother-Captain Stern");
        power = 8;

        addPsychicPowers(1, SANCTIC);

        seperator();

        addWarlordTraits("Unyielding Anvil (GK)", true);

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
