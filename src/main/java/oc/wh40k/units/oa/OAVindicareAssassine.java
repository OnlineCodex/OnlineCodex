package oc.wh40k.units.oa;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class OAVindicareAssassine extends Eintrag {

	RuestkammerStarter rkTransport;

	public OAVindicareAssassine() {
		name = "Vindicare Assassine";
		grundkosten = 150;

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
