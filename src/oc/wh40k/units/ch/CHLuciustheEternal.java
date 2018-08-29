package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHLuciustheEternal extends Eintrag {

	public CHLuciustheEternal() {

		name = "Lucius the Eternal";
        grundkosten = getPts("Lucius the Eternal");
        power = 6;   
		complete();

		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
