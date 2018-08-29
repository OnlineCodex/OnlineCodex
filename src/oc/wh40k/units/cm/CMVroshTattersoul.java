package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMVroshTattersoul extends Eintrag {


	public CMVroshTattersoul() {
		name = "Vrosh Tattersoul";
		grundkosten = 65;

		add(ico = new oc.Picture("oc/wh40k/images/Ahriman.gif"));
		
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {

	}
}
