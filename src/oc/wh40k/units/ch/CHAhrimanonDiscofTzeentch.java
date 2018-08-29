package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHAhrimanonDiscofTzeentch extends Eintrag {

	RuestkammerStarter psychicPowers;

	public CHAhrimanonDiscofTzeentch() {
		name = "Ahriman on Disc of Tzeentch";
		grundkosten = getPts("Ahriman on Disc of Tzeentch");
		power = 8;
		add(ico = new oc.Picture("oc/wh40k/images/Ahriman.gif"));

		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(3);
		((PsychicPowers)psychicPowers.getKammer()).enableDarkHereticus();
		((PsychicPowers)psychicPowers.getKammer()).enableChange();
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
