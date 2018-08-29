package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TAKrootCarnivores extends Eintrag {

	AnzahlPanel squad;

	public TAKrootCarnivores() {
		name = "Kroot Carnivores";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Kroot Carnivores", 10, 20, getPts("Kroot Carnivores") + getPts("Kroot rifle") + getPts("Kroot rifle (melee)"));
		add(squad);

		complete();
	}

	@Override
	public void refreshen() {
		if (squad.getModelle() > 10) {
			power = 5;
		} else {
			power = 3;
		}
	}

}
