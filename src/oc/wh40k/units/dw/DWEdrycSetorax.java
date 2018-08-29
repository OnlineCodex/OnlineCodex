package oc.wh40k.units.dw;

import oc.Eintrag;

public class DWEdrycSetorax extends Eintrag {

	public DWEdrycSetorax() {
		name = "Edryc Setorax";
		grundkosten = 35;

		add(ico = new oc.Picture("oc/wh40k/images/DWEdrycSetorax.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
