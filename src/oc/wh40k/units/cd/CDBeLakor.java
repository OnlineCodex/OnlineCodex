package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDBeLakor extends Eintrag {

	public CDBeLakor() {

		name = "Be'Lakor";

		grundkosten = 350;

		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
