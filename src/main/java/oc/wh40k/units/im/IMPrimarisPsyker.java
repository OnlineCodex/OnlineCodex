package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMPrimarisPsyker extends Eintrag {
	
	RuestkammerStarter psychicPowers;
	
	public IMPrimarisPsyker() {
		name = "Primaris Psyker";
		grundkosten = getPts("Primaris Psyker") + getPts("Laspistol") + getPts("Force stave");
		power = 2;
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(2);
		((PsychicPowers)psychicPowers.getKammer()).enablePsykana();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);

		
		complete();
	}

	//@OVERRIDE
		public void refreshen() {
		}
}