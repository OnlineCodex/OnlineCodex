package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHHeraldofSlaaneshonSteed extends Eintrag {

	public CHHeraldofSlaaneshonSteed() {
		name = "Herald of Slaanesh on Steed";
        grundkosten = getPts("Herald of Slaanesh on Steed");
        power = 4;   
       	
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
