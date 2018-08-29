package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDTheChangeling extends Eintrag {

	public CDTheChangeling() {

		name = "The Changeling";
        grundkosten = getPts("The Changeling");
        power = 5;   
		complete();

	}

	@Override
	public void refreshen() {
	}
}
