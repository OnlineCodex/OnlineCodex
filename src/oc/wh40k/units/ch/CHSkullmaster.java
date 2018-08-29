package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHSkullmaster extends Eintrag {

	public CHSkullmaster() {
		name = "Skullmaster";
        grundkosten = getPts("Skullmaster");
        power = 5;   
       	
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
