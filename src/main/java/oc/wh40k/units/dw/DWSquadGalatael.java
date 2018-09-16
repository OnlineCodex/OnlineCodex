package oc.wh40k.units.dw;

import oc.Eintrag;

public class DWSquadGalatael extends Eintrag {

	public DWSquadGalatael() {
		name = "Squad Crull";
		grundkosten =  245;

		add(ico = new oc.Picture("oc/wh40k/images/DWSquadDonatus.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
