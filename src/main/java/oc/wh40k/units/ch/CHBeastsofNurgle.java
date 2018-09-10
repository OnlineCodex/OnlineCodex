package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CHBeastsofNurgle extends Eintrag {

	AnzahlPanel Nurglings;

	public CHBeastsofNurgle() {

		name = "Beasts of Nurgle";
        grundkosten = 0;
        power = 2; 

        add(Nurglings = new AnzahlPanel(ID, randAbstand, cnt, "Beasts of Nurgle", 1, 9, getPts("Beast of Nurgle")));

		complete();

	}

	@Override
	public void refreshen() {
		power = Nurglings.getModelle() * 2;
	}
}
