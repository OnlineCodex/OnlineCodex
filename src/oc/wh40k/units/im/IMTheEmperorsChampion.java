package oc.wh40k.units.im;

import oc.Eintrag;

public class IMTheEmperorsChampion extends Eintrag {

	public IMTheEmperorsChampion() {
		name = "The Emperor's Champion";
		grundkosten = getPts("The Emperor's Champion");
		power = 6;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);    
	}
}
