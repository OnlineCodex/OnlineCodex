package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDBloodthirsterofUnfetteredFury extends Eintrag {

	
	public CDBloodthirsterofUnfetteredFury() {

		name = "Bloodthirster of Unfettered Fury";
        grundkosten = getPts("Bloodthirster Of Insensate Rage");
        power = 17;   
		complete();

	}

	@Override
	public void refreshen() {
	}
}
