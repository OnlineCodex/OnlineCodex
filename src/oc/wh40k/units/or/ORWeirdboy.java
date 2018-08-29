package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class ORWeirdboy extends Eintrag {

	OptionsEinzelUpgrade o1;
	RuestkammerStarter psychicPowers;
	
	public ORWeirdboy() {

		kategorie = 1;
		name = "Wyrdboy";
		grundkosten = getPts("Weirdboy") + getPts("Weirdboy staff");
        power = 4;

		add(ico = new oc.Picture("oc/wh40k/images/Wyrdboy.gif"));
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(2);
		((PsychicPowers)psychicPowers.getKammer()).enablePowerOfTheWaaagh();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(false);
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {
	}
	
}
