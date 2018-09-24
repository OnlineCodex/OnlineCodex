package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class AMSalamanderReconSquadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade camo;
	RuestkammerStarter v1;
	RuestkammerStarter v2;
	RuestkammerStarter v3;
	
	public AMSalamanderReconSquadron() {
		name = "Salamander Recon Squadron";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/ABSalamanderReconSquadron.jpg"));

		add(camo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 20));
		
		seperator();
		
		v1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMSalamander", "Salamander");
		v1.initKammer();
        v1.setGrundkosten(55);
		add(v1);

		seperator();

		v2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMSalamander", "Salamander");
		v2.initKammer();
        v2.setGrundkosten(55);
		add(v2);

		seperator();

		v3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMSalamander", "Salamander");
		v3.initKammer();
        v3.setGrundkosten(55);
		add(v3);

		complete();
	}

	@Override
	public void refreshen() {
		int camoKosten = (v1.isSelected()?20:0) + (v2.isSelected()?20:0) + (v3.isSelected()?20:0);
		camo.setPreis(camoKosten);
		camo.setAktiv(camoKosten>0);
	}

}
