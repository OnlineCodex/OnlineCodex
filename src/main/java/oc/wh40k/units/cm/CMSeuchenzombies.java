package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CMSeuchenzombies extends Eintrag {

	AnzahlPanel kultisten;
	OptionsUpgradeGruppe mal;
	RuestkammerStarter champion;
	OptionsEinzelUpgrade schrotflinte;
	OptionsZaehlerGruppe schwereWaffe;
	OptionsZaehlerGruppe autogewehre;

	public CMSeuchenzombies() {
		//name = "Seuchenzombies\n";
		grundkosten = 10;
		
		kultisten = new AnzahlPanel(ID, randAbstand, cnt, "Seuchenzombies", 10, 35, 4);
		add(kultisten);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosKultisten.gif"));

		complete();

	}

	@Override
	public void refreshen() {

	}
}
