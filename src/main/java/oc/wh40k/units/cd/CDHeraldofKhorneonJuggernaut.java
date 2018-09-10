package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDHeraldofKhorneonJuggernaut extends Eintrag {

	public CDHeraldofKhorneonJuggernaut() {
		name = "Herald of Khorne on Juggernaut";
        grundkosten = getPts("Herald of Khorne on Juggernaut");
        power = 5;   
       	
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
