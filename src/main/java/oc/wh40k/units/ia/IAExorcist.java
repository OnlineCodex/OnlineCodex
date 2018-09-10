package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class IAExorcist extends Eintrag {

	OptionsUpgradeGruppe o1;

	public IAExorcist() {
		name = "Exorzist";
		grundkosten = 125;

		add(ico = new oc.Picture("oc/wh40k/images/ASExorzist.jpg"));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozer-Schaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
	    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Laud hailer", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
