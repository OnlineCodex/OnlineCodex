package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHMortarion extends Eintrag {
	
	RuestkammerStarter psychicPowers;
	
	public CHMortarion() {

		name = "Mortarion";
        grundkosten = getPts("Mortarion");
        power = 24;
        
        seperator();
        
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(3);
        ((PsychicPowers)psychicPowers.getKammer()).enableContagion();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
