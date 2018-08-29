package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHCorbaxUtterblight extends Eintrag {

	public CHCorbaxUtterblight() {

		name = "Cor'bax Utterblight";
        grundkosten = getPts("Cor'bax Utterblight");
        power = 12;   

		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
