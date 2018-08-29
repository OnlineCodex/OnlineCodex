package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TAKrootoxRiders extends Eintrag {

	AnzahlPanel squad;

	public TAKrootoxRiders() {
		name = "Krootox Riders";
		grundkosten = 0;

		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Krootox Riders", 1, 3, getPts("Krootox Riders") + getPts("Kroot gun") + getPts("Krootox fists"));
		add(squad);

		complete();
	}

	@Override
	public void refreshen() {
		if (squad.getModelle() > 2) {
			power = 5;
		} else if (squad.getModelle() > 1){
			power = 4;
		} else {
			power = 2;
		}
	}

}
