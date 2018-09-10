package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CHFleshHounds extends Eintrag {

	AnzahlPanel hounds;

	public CHFleshHounds() {

		name = "Flesh Hounds";
        grundkosten = 0;
        power = 5; 

        add(hounds = new AnzahlPanel(ID, randAbstand, cnt, "Flesh Hounds", 5, 20, getPts("Flesh Hounds")));
        
		complete();

	}

	public void deleteYourself() { 
	}


	@Override
	public void refreshen() {	
		power = 5 +
				((hounds.getModelle()==10)?5:0) +
				((hounds.getModelle()==15)?10:0) +
				((hounds.getModelle()==20)?15:0);
	}
}
