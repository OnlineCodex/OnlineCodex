package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class AMDestroyerTankHunterSquadron extends Eintrag {

	RuestkammerStarter v1;
	RuestkammerStarter v2;
	RuestkammerStarter v3;
	OptionsEinzelUpgrade camo;

	public AMDestroyerTankHunterSquadron() {
		name = "Destroyer Tank Hunter Squadron";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/ABDestroyerTankHunterSquadron.jpg"));

		add(camo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 20));
		
		v1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMDestroyer", "Destroyer");
		v1.initKammer();
        v1.setGrundkosten(160);
		add(v1);

		seperator();

		v2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMDestroyer", "Destroyer");
		v2.initKammer();
        v2.setGrundkosten(160);
		add(v2);

		seperator();

		v3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMDestroyer", "Destroyer");
		v3.initKammer();
        v3.setGrundkosten(160);
		add(v3);

		complete();
	}

	@Override
	public void refreshen() {
		int camoKosten = 0 + (v1.isSelected()?20:0) + (v2.isSelected()?20:0) + (v3.isSelected()?20:0);
		camo.setPreis(camoKosten);
		camo.setAktiv(camoKosten>0);
	}

}
