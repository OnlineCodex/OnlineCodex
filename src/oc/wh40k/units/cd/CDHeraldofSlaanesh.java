package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDHeraldofSlaanesh extends Eintrag {

	public CDHeraldofSlaanesh() {
		name = "Herald of Slaanesh";
        grundkosten = getPts("Herald of Slaanesh");
        power = 3;   
       	
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
