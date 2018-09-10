package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHEpidemius extends Eintrag {

	public CHEpidemius() {

		name = "Epidemius";
        grundkosten = getPts("Epidemius");
        power = 5;  

		add(ico = new oc.Picture("oc/wh40k/images/CDEpidemius.gif"));
		
		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
