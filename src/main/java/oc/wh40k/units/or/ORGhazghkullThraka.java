package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORGhazghkullThraka extends Eintrag {

    RuestkammerStarter squigs;

	public ORGhazghkullThraka() {

		kategorie = 1;
		name = "Ghazghkull Thraka";
		grundkosten = getPts("Ghazghkull Thraka");
        power = 11;
        
		add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

		complete();
	}
	
	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
