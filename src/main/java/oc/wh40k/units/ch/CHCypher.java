package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHCypher extends Eintrag {

	public CHCypher() {

		name = "Cypher";
        grundkosten = getPts("Cypher");
        power = 6;   

		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
