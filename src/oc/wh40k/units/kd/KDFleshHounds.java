package oc.wh40k.units.kd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class KDFleshHounds extends Eintrag {

	AnzahlPanel CDBluthundedesKhorne;
	OptionsEinzelUpgrade karanak;

	boolean karanakSelected  = false;

	public KDFleshHounds() {

		name = "Flesh Hounds";

		grundkosten = 0;

		CDBluthundedesKhorne = new AnzahlPanel(ID, randAbstand, cnt, "Bluthunde des Khorne", 5, 20, 16);

		add(CDBluthundedesKhorne);

		complete();

	}

	public void deleteYourself() { 
	}


	@Override
	public void refreshen() {
	}
}
