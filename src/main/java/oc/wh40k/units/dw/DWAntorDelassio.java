package oc.wh40k.units.dw;

import oc.Eintrag;

public class DWAntorDelassio extends Eintrag {

	public DWAntorDelassio() {
		name = "Antor Delassio";
		grundkosten =  35;

		add(ico = new oc.Picture("oc/wh40k/images/DWAntorDelassio.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
