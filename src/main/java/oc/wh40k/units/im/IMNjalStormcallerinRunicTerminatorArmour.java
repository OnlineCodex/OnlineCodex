package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.TEMPESTAS_DISCIPLINE;

public class IMNjalStormcallerinRunicTerminatorArmour extends Eintrag {

    private final RuestkammerStarter psychicPowers;

	public IMNjalStormcallerinRunicTerminatorArmour() {
        name = "Njal Sturmbringer in Runic Terminator Armour";
        grundkosten = getPts("Njal Stormcaller in Runic Terminator Armour");
        power = 9;
        
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
