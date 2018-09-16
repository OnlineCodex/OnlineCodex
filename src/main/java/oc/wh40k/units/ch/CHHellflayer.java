package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHHellflayer extends Eintrag {

	public CHHellflayer() {
		name = "Hellflayer";
        grundkosten = getPts("Hellflayer");
        power = 5;   
       	
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
