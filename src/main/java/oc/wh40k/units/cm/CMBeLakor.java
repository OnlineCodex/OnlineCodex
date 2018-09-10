package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMBeLakor extends Eintrag {

	public CMBeLakor() {

		name = "Be'Lakor";

		grundkosten = 350;

		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
