package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class AEIncubi extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;

	public AEIncubi() {
		name = "Incubi";
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Incubi", 5, 10, getPts("Incubi") + getPts("Klaive"));
		add(squad);

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "AEKlaivex", "Klaivex");
		rkBoss.initKammer();
		add(rkBoss);

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		if(squad.getModelle() > 5){
			power = 9;
		} else{
			power = 5;
		}
	}

}
