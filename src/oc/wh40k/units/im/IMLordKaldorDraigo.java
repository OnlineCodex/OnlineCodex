package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMLordKaldorDraigo extends Eintrag {

	RuestkammerStarter psychicPowers;
	
	public IMLordKaldorDraigo() {
		name = "Lord Kaldor Draigo";
		grundkosten = getPts("Lord Kaldor Draigo");
		power = 12;
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(2);
		((PsychicPowers)psychicPowers.getKammer()).enableSanctic();
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
