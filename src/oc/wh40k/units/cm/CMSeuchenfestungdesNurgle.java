package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMSeuchenfestungdesNurgle extends Eintrag {

	public CMSeuchenfestungdesNurgle() {
		name = "Seuchenfestung des Nurgle";
		grundkosten = 700;

		add(ico = new oc.Picture("oc/wh40k/images/SeuchenfestungdesNurgle.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
