package oc.wh40k.units.or;

import oc.Eintrag;

public class ORMadDokGrotsnik extends Eintrag {

	public ORMadDokGrotsnik() {
		name = "Mad Dok Grotsnik";
		kategorie = 1;
		grundkosten = getPts("Mad Dok Grotsnik");
        power = 7;

		add(ico = new oc.Picture("oc/wh40k/images/DokGrotsnik.gif"));
		
		complete();
	}
	
	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}

}
