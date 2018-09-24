package oc.wh40k.units.dw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;

public class DWRhino extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	OptionsUpgradeGruppe o1;

	public DWRhino() {
		name = "Rhino";
		grundkosten = 35;

		add(ico = new oc.Picture("oc/wh40k/images/SMLandSpeederStorm.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

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
