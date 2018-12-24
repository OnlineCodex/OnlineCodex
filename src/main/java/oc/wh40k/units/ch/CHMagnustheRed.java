package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.ChaosGod.TZEENTCH;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CHANGE;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;

public class CHMagnustheRed extends Eintrag {

    public CHMagnustheRed() {
        name = "Magnus the Red";
        grundkosten = getPts("Magnus the Red");
        power = 21;

        addPsychicPowers(3, ImmutableSet.of(TZEENTCH), CHANGE, DARK_HERETICUS);

        seperator();

        addWarlordTraits("Lord of Forbidden Lore", true);

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
