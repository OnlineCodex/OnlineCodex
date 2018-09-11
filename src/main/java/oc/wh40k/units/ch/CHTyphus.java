package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHTyphus extends Eintrag {

	RuestkammerStarter psychicPowers;
	
	public CHTyphus() {

		name = "Typhus";
        grundkosten = getPts("Typhus");
        power = 9;   
		complete();

		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(2);
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
