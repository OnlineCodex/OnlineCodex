package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDBeastsofNurgle extends Eintrag {

	AnzahlPanel Nurglings;

	public CDBeastsofNurgle() {

		name = "Beasts of Nurgle";
        grundkosten = 0;
        power = 2; 

        add(Nurglings = new AnzahlPanel(ID, randAbstand, cnt, "Beasts of Nurgle", 1, 9, getPts("Beasts of Nurgle")));

		complete();

	}

	@Override
	public void refreshen() {
	}
}
