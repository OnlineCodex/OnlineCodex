package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHAetaosraukeres extends Eintrag {

	public CHAetaosraukeres() {

		name = "Aetaos'rau'keres";
        grundkosten = getPts("Aetaos'rau'keres");
        power = 35;   

		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
