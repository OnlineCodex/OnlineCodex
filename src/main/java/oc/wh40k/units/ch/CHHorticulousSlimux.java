package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHHorticulousSlimux extends Eintrag {

	public CHHorticulousSlimux() {
		name = "Horticulous Slimux";
        grundkosten = getPts("Horticulous Slimux");
        power = 4;   
       	
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
