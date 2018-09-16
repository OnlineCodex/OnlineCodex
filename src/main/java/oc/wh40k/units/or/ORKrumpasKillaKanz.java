package oc.wh40k.units.or;

import oc.Eintrag;

public class ORKrumpasKillaKanz extends Eintrag {

	public ORKrumpasKillaKanz() {

		kategorie = 5;
		name = "Krumpa's Killa Kanz";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/MekBossBuzzgob.gif"));
		complete();
	}

	public void deleteYourself() {
		super.deleteYourself();

	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
