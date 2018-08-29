package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMArchCenturionCarnacCommodus extends Eintrag {
//TODO Astral Claws only
	public SMArchCenturionCarnacCommodus() {
		name = "Arch-Centurion Carnac Commodus";
		grundkosten = 105;

		add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
}
