package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class NEAnrakyrtheTraveller extends Eintrag {
    
    RuestkammerStarter rkTransport;

	public NEAnrakyrtheTraveller() {
		name = "Anrakyr the Traveller";
		grundkosten = getPts("Anrakyr the Traveller");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        power = 9;
	}

}
