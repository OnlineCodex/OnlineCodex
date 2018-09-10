package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORGorkanaut extends Eintrag {

	public ORGorkanaut() {

		kategorie = 5;
		name = "Gorkanaut";
		grundkosten = getPts("Gorkanaut") + 
				  getPts("Skorcha") +
				  2 * getPts("Twin big shoota") +
				  2 * getPts("Rokkit launcha") + 
				  getPts("Deffstorm mega-shoota") + 
				  getPts("Klaw of Gork (or possibly Mork)");
		power = 19;
		
		add(ico = new oc.Picture("oc/wh40k/images/Gorkanaut.gif"));

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}