package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;

public class SMQuadMortarSupportBattery extends Eintrag {

	AnzahlPanel squad;

	public SMQuadMortarSupportBattery() {
		name = "Quad Mortar Support Battery\n";
		grundkosten = 0;
		überschriftSetzen=true;
		

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Quad Mortar Rapier Carrier", "Quad Mortar Rapier Carriers", 1, 3, 60);
		add(squad);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
