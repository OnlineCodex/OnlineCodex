package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CHANGE;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;

public class CHAhriman extends Eintrag {

    public CHAhriman() {
        name = "Ahriman";
        grundkosten = getPts("Ahriman");
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/Ahriman.gif"));

        seperator();

        addPsychicPowers(3, DARK_HERETICUS, CHANGE);

        seperator();

        addWarlordTraits("Otherworldly Prescience", true);

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
