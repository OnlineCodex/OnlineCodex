package oc.wh40k.units.im;

import oc.Eintrag;

public class IMHighMarshalHelbrecht extends Eintrag {

	public IMHighMarshalHelbrecht() {
		name = "High Marshal Helbrecht";
		grundkosten = getPts("High Marshal Helbrecht");
		power = 9;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);    
	}
}
