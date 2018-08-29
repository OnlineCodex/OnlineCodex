package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class AESpiritseer extends Eintrag {
	
	RuestkammerStarter psychicPowers;
	
	public AESpiritseer() {
		name = "Spiritseer";
		grundkosten = getPts("Spiritseer") + getPts("Shuriken pistol") + getPts("Witch staff");
		power = 4;

		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(1);
		((PsychicPowers)psychicPowers.getKammer()).enableRunesOfBattle();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();
	}

	@Override
	public void refreshen() { 
	}
}