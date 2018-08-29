package oc.wh40k.units.oa;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class OACallidusAssassine extends Eintrag {

	RuestkammerStarter rkTransport;

	public OACallidusAssassine() {
		name = "Callidus Assassine";
		grundkosten = 145;

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
