package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEDoomsdayArk extends Eintrag {
    
	public NEDoomsdayArk() {
		name = "Doomsday Ark";
		grundkosten = getPts("Doomsday Ark")+getPts("Doomsday cannon")+getPts("Gauss flayer array")*2;

		add(ico = new oc.Picture("oc/wh40k/images/NEDominatorBarke.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
		power = 10;
	}

}
