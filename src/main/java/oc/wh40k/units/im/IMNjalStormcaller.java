package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.TEMPESTAS_DISCIPLINE;

public class IMNjalStormcaller extends Eintrag {

    private final RuestkammerStarter psychicPowers;

	public IMNjalStormcaller() {
        name = "Njal Sturmbringer";
        grundkosten = getPts("Njal Stormcaller");
        power = 7;
        
        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(3, TEMPESTAS_DISCIPLINE), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(false);
        add(psychicPowers);

        seperator();
        
		addWarlordTraits("", true);

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