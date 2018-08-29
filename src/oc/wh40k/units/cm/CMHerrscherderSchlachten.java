package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMHerrscherderSchlachten extends Eintrag {

	public CMHerrscherderSchlachten() {
		name = "Herrscher der Schlachten";
		grundkosten = 750;

		add(ico = new oc.Picture("oc/wh40k/images/HerrscherderSchlachten.gif"));
		

		complete();

	}

	public void refreshen() {
        setUnikat(true);
	}
}
