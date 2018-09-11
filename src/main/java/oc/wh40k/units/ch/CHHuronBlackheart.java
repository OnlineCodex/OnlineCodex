package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHHuronBlackheart extends Eintrag {

	RuestkammerStarter psychicPowers;
	
	public CHHuronBlackheart() {

		name = "Huron Blackheart";
        grundkosten = getPts("Huron Blackheart");
        power = 7; 
        
        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(1);
		((PsychicPowers)psychicPowers.getKammer()).enableDarkHereticus();
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
