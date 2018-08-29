package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDBloodthirsterofInsensateRage extends Eintrag {

	public CDBloodthirsterofInsensateRage() {

		name = "Bloodthirster of Insensate Rage";
        grundkosten = getPts("Bloodthirster Of Insensate Rage");
        power = 17;   
		complete();

	}

	@Override
	public void refreshen() {
	}
}
