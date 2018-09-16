package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMNecrosius extends Eintrag {

	

	public CMNecrosius() {
		name = "Necrosius";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/Necrosius.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
