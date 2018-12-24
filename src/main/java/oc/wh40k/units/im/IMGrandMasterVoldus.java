package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANCTIC;

public class IMGrandMasterVoldus extends Eintrag {

    public IMGrandMasterVoldus() {
        name = "Grand Master Voldus";
        grundkosten = getPts("Grand Master Voldus");
        power = 10;

        seperator();

        addPsychicPowers(3, SANCTIC);

        seperator();

        addWarlordTraits("Lore Master (GK)", true);

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
