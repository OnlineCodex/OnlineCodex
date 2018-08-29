package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHBloodThrone extends Eintrag {

	public CHBloodThrone() {
		name = "Blood Throne";
        grundkosten = getPts("Blood Throne");
        power = 6;   
       	
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
