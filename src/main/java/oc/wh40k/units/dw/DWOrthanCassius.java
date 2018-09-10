package oc.wh40k.units.dw;

import oc.Eintrag;

public class DWOrthanCassius extends Eintrag {

	public DWOrthanCassius() {
		name = "Orthan Cassius";
		grundkosten = 95;

		add(ico = new oc.Picture("oc/wh40k/images/DWOrthanCassius.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
