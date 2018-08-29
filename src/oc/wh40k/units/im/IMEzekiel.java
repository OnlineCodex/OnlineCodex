package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMEzekiel extends Eintrag {

	RuestkammerStarter psychicPowers;
	
	public IMEzekiel() {
		name = "Ezekiel";
		grundkosten = getPts("Ezekiel");
		power = 7;
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(3);
		((PsychicPowers)psychicPowers.getKammer()).enableInterromancy();
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
