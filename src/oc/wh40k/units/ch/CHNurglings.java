package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CHNurglings extends Eintrag {

	AnzahlPanel Nurglings;

	public CHNurglings() {

		name = "Nurglings";
        grundkosten = 0;
        power = 3; 

        add(Nurglings = new AnzahlPanel(ID, randAbstand, cnt, "Nurglings", 3, 9, getPts("Nurglings")));

		complete();

	}

	@Override
	public void refreshen() {
		power = 3 +
				((Nurglings.getModelle()==6)?3:0) +
				((Nurglings.getModelle()==9)?6:0);
	}
}
