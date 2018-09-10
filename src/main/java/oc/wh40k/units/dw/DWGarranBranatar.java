package oc.wh40k.units.dw;

import oc.Eintrag;

public class DWGarranBranatar extends Eintrag {

	public DWGarranBranatar() {
		name = "Garran Branatar";
		grundkosten =  60;

		add(ico = new oc.Picture("oc/wh40k/images/DWGarranBranatar.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
