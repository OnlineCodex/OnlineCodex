package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANCTIC;

public class IMCastellanCrowe extends Eintrag {

    private final RuestkammerStarter psychicPowers;

    public IMCastellanCrowe() {
        name = "Castellan Crowe";
        grundkosten = getPts("Castellan Crowe");
        power = 7;

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, SANCTIC), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();

        addWarlordTraits("Hammer of Righteousness (GK)", true);

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
