package oc.wh40k.units.im;

import oc.Eintrag;

public class IMColonelIronHandStraken extends Eintrag {

	public IMColonelIronHandStraken() {
		name = "Colonel 'Iron Hand' Straken";
		grundkosten = getPts("Colonel 'Iron Hand' Straken");
		power = 5;
		
		complete();
	}

	//@OVERRIDE
		public void refreshen() {
	        setUnikat(true);
		}
}