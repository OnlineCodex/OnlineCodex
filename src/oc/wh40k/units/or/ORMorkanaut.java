package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORMorkanaut extends Eintrag {

	public ORMorkanaut() {

		kategorie = 5;
		name = "Morkanaut";
		grundkosten = getPts("Morkanaut") + 
					  getPts("Kustom mega-blasta") +
					  2 * getPts("Twin big shoota") +
					  2 * getPts("Rokkit launcha") + 
					  getPts("Kustom mega-kannon") + 
					  getPts("Klaw of Gork (or possibly Mork)");
		power = 18;
		
		add(ico = new oc.Picture("oc/wh40k/images/Gorkanaut.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kustom force field", getPts("Kustom force field")));

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}