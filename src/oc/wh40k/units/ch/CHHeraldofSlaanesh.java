package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHHeraldofSlaanesh extends Eintrag {

	RuestkammerStarter psychicPowers;
	
	public CHHeraldofSlaanesh() {
		name = "Herald of Slaanesh";
        grundkosten = getPts("Herald of Slaanesh");
        power = 3;   
       	
        seperator();
        
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers)psychicPowers.getKammer()).enableSlaanesh();
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
