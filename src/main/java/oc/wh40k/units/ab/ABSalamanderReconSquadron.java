package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ABSalamanderReconSquadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter v1;
	RuestkammerStarter v2;
	RuestkammerStarter v3;

	public ABSalamanderReconSquadron() {
		name = "Salamander Recon Squadron";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/ABSalamanderReconSquadron.jpg"));

		v1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABSalamander", "Salamander");
		v1.initKammer();
        v1.setGrundkosten(55);
		add(v1);

		seperator();

		v2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABSalamander", "Salamander");
		v2.initKammer();
        v2.setGrundkosten(55);
		add(v2);

		seperator();

		v3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABSalamander", "Salamander");
		v3.initKammer();
        v3.setGrundkosten(55);
		add(v3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
