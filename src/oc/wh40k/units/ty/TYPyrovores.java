package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TYPyrovores extends Eintrag {

	AnzahlPanel squad;

	public TYPyrovores() {
		name = "Pyrovores";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Pyrovore", "Pyrovores", 1, 3, getPts("Pyrovores") + getPts("Flamespurt") + getPts("Acid maw"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/TYPyrovoren.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
		power = squad.getModelle() * 2;
	}

}
