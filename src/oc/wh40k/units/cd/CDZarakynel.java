package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDZarakynel extends Eintrag {

	public CDZarakynel() {
		name = "Zarakynel";
		grundkosten = 666;

		add(ico = new oc.Picture("oc/wh40k/images/Zarakynel.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
