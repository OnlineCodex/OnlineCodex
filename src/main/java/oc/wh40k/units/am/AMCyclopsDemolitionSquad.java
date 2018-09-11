package oc.wh40k.units.am;

import oc.AnzahlPanel;
import oc.Eintrag;

public class AMCyclopsDemolitionSquad extends Eintrag {

	AnzahlPanel squad;

	public AMCyclopsDemolitionSquad() {
		name = "Cyclops Demolition Squad";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Cyclops team", 1, 3, 30);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGVendettaGunshipSquadron.jpg"));

        complete();
	}

	@Override
	public void refreshen() {
	}

}
