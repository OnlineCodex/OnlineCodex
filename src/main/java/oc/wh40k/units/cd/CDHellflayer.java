package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDHellflayer extends Eintrag {

	public CDHellflayer() {
		name = "Hellflayer";
        grundkosten = getPts("Hellflayer");
        power = 5;   
       	
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
