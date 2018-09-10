package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TYMucolidSpores extends Eintrag {

	AnzahlPanel squad;

	public TYMucolidSpores() {
		name = "Mucolid Spores";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Mucolid Spore", 1, 3, getPts("Mucolid Spore"));
		add(squad);

		complete();
	}

	@Override
	public void refreshen() {
		power = squad.getModelle() * 1;
	}

}
