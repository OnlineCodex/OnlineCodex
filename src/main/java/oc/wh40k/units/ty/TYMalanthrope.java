//IA Xenos + FAQ 1.0
package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TYMalanthrope extends Eintrag {

	AnzahlPanel squad;

	public TYMalanthrope() {
		name = "Malanthrope";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Malanthrope", "Malanthrope", 1, 3, getPts("Malanthrope") + getPts("Grasping tail"));
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYMalanthrope.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
		power = squad.getModelle() * 5;
	}

}
