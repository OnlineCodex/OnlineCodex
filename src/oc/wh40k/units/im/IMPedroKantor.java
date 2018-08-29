package oc.wh40k.units.im;

import oc.Eintrag;

public class IMPedroKantor extends Eintrag {

	public IMPedroKantor() {
		name = "Pedro Kantor";
		grundkosten = getPts("Pedro Kantor");
		power = 9;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);    
	}
}
