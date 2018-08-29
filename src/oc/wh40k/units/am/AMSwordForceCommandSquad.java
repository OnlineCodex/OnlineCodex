package oc.wh40k.units.am;

import oc.Eintrag;

public class AMSwordForceCommandSquad extends Eintrag {

	public AMSwordForceCommandSquad() {
		name = "Sword Force Command Squad";
		grundkosten = 125;


		add(ico = new oc.Picture("oc/wh40k/images/SwordForceCommandSquad.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
