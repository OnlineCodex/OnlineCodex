package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IAEversorAssassin extends Eintrag {

	RuestkammerStarter rkTransport;

	public IAEversorAssassin() {
		name = "Eversor Assassine";
		grundkosten = 135;

		add(ico = new oc.Picture("oc/wh40k/images/IGCommissarYarrick.jpg"));
		
		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
