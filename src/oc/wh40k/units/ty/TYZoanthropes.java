package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class TYZoanthropes extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter pod;
	OptionsEinzelUpgrade neurotrophe;
	RuestkammerStarter psychicPowers;
	
	public TYZoanthropes() {
		name = "Zoanthropes";
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Zoanthrope", "Zoanthropes", 3, 6, getPts("Zoanthropes") + getPts("Claws and teeth"));
		add(squad);
		
		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYZoantrophen.jpg"));
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(1);
		((PsychicPowers)psychicPowers.getKammer()).enableHiveMind();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();
	}

	@Override
	public void refreshen() {
		power = 6;
		if(squad.getModelle()>3){
			power = 12;
		}
	}

}
