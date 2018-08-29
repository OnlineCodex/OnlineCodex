package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMWyrdvanePsykers extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter psychicPowers;
	
	public IMWyrdvanePsykers() {
		name = "Wyrdvane Psykers";
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Wyrdvane Psyker", 3, 9, getPts("Wyrdvane Psykers") + getPts("Laspistol") + getPts("Wyrdvane stave")));
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(1);
		((PsychicPowers)psychicPowers.getKammer()).enablePsykana();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(squad.getModelle() > 6){
			power = 3;
		} else if(squad.getModelle() > 3){
			power = 2;
		} else {
			power = 1;
		}
	}
}