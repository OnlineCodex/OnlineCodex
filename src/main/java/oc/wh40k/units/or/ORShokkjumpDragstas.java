package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.Eintrag;

public class ORShokkjumpDragstas extends Eintrag {

	AnzahlPanel buggies;

	public ORShokkjumpDragstas() {

		kategorie = 4;
		grundkosten = 0;

		buggies = new AnzahlPanel(ID, randAbstand, cnt, "Shokkjump Dragsta", "Shokkjump Dragstas", 1, 3, getPts("Shokkjump Dragstas"));
		add(buggies);

		add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
		seperator();
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {

		power = buggies.getModelle() * 6;
	}
}
