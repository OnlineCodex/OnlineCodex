package oc.wh40k.units.im;

import oc.Eintrag;

public class IMLukastheTrickster extends Eintrag {

	public IMLukastheTrickster() {
		name = "Lukas the Trickster";
		grundkosten = getPts("Lukas the Trickster");
		power = 6;
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
}
