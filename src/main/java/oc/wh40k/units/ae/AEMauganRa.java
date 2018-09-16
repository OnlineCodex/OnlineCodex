package oc.wh40k.units.ae;

import oc.Eintrag;

public class AEMauganRa extends Eintrag {

	public AEMauganRa() {
		name = "Maugan Ra";
		grundkosten = getPts("Maugan Ra");
		power = 8;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);    
	}
}