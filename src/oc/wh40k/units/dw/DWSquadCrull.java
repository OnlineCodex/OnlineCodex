package oc.wh40k.units.dw;

import oc.Eintrag;

public class DWSquadCrull extends Eintrag {

	public DWSquadCrull() {
		name = "Squad Crull";
		grundkosten =  205;

		add(ico = new oc.Picture("oc/wh40k/images/DWSquadDonatus.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
