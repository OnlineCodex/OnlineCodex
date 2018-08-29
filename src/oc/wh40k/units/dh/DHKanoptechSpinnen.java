package oc.wh40k.units.dh;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DHKanoptechSpinnen extends Eintrag {

	RuestkammerStarter s1;
	RuestkammerStarter s2;
	RuestkammerStarter s3;

	public DHKanoptechSpinnen() {
		name = "Kanoptech-Spinnen";
		grundkosten = 0;
		überschriftSetzen = true;
        
		add(ico = new oc.Picture("oc/wh40k/images/NEKanoptechSpinnen.jpg"));

		seperator();

		s1 = new RuestkammerStarter(ID, randAbstand, cnt, "DHKanoptechSpinneKammer", "Kanoptech-Spinne");
		s1.initKammer();
		add(s1);

		s2 = new RuestkammerStarter(ID, randAbstand, cnt, "DHKanoptechSpinneKammer", "Kanoptech-Spinne");
		s2.initKammer();
		add(s2);

		s3 = new RuestkammerStarter(ID, randAbstand, cnt, "DHKanoptechSpinneKammer", "Kanoptech-Spinne");
		s3.initKammer();
		add(s3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
