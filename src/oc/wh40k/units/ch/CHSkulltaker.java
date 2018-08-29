package oc.wh40k.units.ch;

import oc.OptionsEinzelUpgrade;
import oc.Eintrag;

public class CHSkulltaker extends Eintrag {

	public CHSkulltaker() {

		name = "Skulltaker";
        grundkosten = getPts("Skulltaker");
        power = 5;   
		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
