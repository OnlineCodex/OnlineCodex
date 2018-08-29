package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHChaosHellwright extends Eintrag {

	public CHChaosHellwright() {

		name = "Chaos Hellwright";
        grundkosten = getPts("Chaos Hellwright");
        power = 8;   

		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
