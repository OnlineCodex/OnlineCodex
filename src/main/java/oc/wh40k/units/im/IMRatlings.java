package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMRatlings extends Eintrag {

	AnzahlPanel squad;

	boolean lastState = false;

	public IMRatlings() {
		name = "Ratlings";
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Ratlings", 5, 10, getPts("Ratlings") + getPts("Sniper rifle (AM)")));
		complete();
	}

	@Override
	public void refreshen() {
		power = 2;
		if(squad.getModelle() > 5){
			power = 4;
		}
	}

}
