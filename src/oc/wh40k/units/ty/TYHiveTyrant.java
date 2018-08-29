package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class TYHiveTyrant extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	RuestkammerStarter psychicPowers;
	RuestkammerStarter waffen;

	public TYHiveTyrant() {
		name = "Hive Tyrant";
		grundkosten = getPts("Hive Tyrant") + getPts("Prehensile pincer tail");
		power = 10;

		add(ico = new oc.Picture("oc/wh40k/images/TYSchwarmtyrantFuss.jpg"));
		
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Wings", "Wings", 47)); //Hier gibt es keinen Eintrag
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Hive Tyrant)")));
		
		seperator();
		
		waffen = new RuestkammerStarter(ID, randAbstand, cnt, "TYRuestkammer", "");
		((TYRuestkammer)waffen.getKammer()).setType("Hive Tyrant");
		waffen.initKammer();
		add(waffen);
		waffen.setButtonText("Wargear");
		waffen.setAbwaehlbar(false);
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(2);
		((PsychicPowers)psychicPowers.getKammer()).enableHiveMind();
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
