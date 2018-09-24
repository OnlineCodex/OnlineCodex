package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMDeathCultAssassins extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public IMDeathCultAssassins() {
		name = "Death Cult Assassins\n";
		grundkosten = 0;
		überschriftSetzen = true;
		power = 1;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Death Cult Assassin", 2, 10, getPts("Death Cult Assassins")+getPts("Death Cult power blades"));
		add(squad);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(squad.getModelle()<=2)
			power = 1;
		else if(squad.getModelle()<=4)
			power = 2;
		else if(squad.getModelle()<=6)
			power = 3;
		else if(squad.getModelle()<=8)
			power = 4;
		else if(squad.getModelle()<=8)
			power = 5;
	}

}
