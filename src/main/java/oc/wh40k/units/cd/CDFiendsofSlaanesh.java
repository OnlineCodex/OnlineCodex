package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDFiendsofSlaanesh extends Eintrag {

	AnzahlPanel fiends;

	public CDFiendsofSlaanesh() {

		name = "Fiends of Slaanesh";
        grundkosten = 0;
        power = 5; 

        add(fiends = new AnzahlPanel(ID, randAbstand, cnt, "Fiends of Slaanesh", 1, 9, getPts("Fiends of Slaanesh")));
        
		complete();

	}

	public void deleteYourself() { 
	}


	@Override
	public void refreshen() {	
		power = fiends.getModelle();
	}
}
