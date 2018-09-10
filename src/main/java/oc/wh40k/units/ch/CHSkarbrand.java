package oc.wh40k.units.ch;

import oc.BuildaHQ;
import oc.Eintrag;

public class CHSkarbrand extends Eintrag {

	public CHSkarbrand() {

		name = "Skarbrand";
        grundkosten = getPts("Skarbrand");
        power = 19;   
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}
}
