package oc.wh40k.units.da;

import oc.Eintrag;

public class DASeraphicus extends Eintrag {

	public DASeraphicus() {
		name = "Seraphicus";
		grundkosten = 125;

		add(ico = new oc.Picture("oc/wh40k/images/DASeraphicus.gif"));
		
		seperator();
		
		addToInformationVector("DAHQ", 1);
		
		complete();
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("DAHQ", -1);
	}
	
	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
}