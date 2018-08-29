package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMHuronSchwarzherz extends Eintrag {

	public CMHuronSchwarzherz() {
		name = "Huron Schwarzherz";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/HuronBlackheart.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
