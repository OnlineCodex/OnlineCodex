package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IMPrimarisLibrarian extends Eintrag {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IMPrimarisLibrarian.class);
	
	OptionsEinzelUpgrade jump;
	RuestkammerStarter waffenUndReliquien;
	RuestkammerStarter psychicPowers;
	
	public IMPrimarisLibrarian() {
		name = "Primaris Librarian";
		grundkosten = getPts("Primaris Librarian") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Bolt pistol") + getPts("Force sword");

		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(2);
        
        LOGGER.info(buildaVater.getKontingentTyp() + " " + buildaVater.getFormationType());
        
        if(!buildaVater.getFormationType().equals("Dark Angels") && !buildaVater.getFormationType().equals("Blood Angels"))
        	((PsychicPowers)psychicPowers.getKammer()).enableLibrarius();
        if(buildaVater.getFormationType().equals("Blood Angels"))
        	((PsychicPowers)psychicPowers.getKammer()).enableSanguinary();
        if(buildaVater.getFormationType().equals("Dark Angels"))
        	((PsychicPowers)psychicPowers.getKammer()).enableInterromancy();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();
	}

	@Override
	public void refreshen() {
		power = 7;
	}
}
