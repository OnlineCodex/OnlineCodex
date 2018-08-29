package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class ORStompa extends Eintrag {

	public ORStompa() {
		name = "Stompa";
		grundkosten = getPts("Stompa") +
					  getPts("Deffkannon") +
					  getPts("Supa Gatler") +
					  getPts("Big shoota") * 3 +
					  getPts("Twin big shoota") +
					  getPts("Supa-rokkit") +
					  getPts("Skorcha") +
					  getPts("Mega-choppa");
		power = 49;

		add(ico = new oc.Picture("oc/wh40k/images/Stampfa.gif"));
		
		seperator();
		
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Additional Supa-rokkits", 2, getPts("Supa-rokkit")));

		
		complete();

	}

	public void refreshen(){}
}