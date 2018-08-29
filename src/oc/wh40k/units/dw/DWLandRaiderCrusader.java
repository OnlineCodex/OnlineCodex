package oc.wh40k.units.dw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RefreshListener;

public class DWLandRaiderCrusader extends Eintrag {


	public DWLandRaiderCrusader() {
		name = "Land Raider Crusader";
		grundkosten = 250;


		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderCrusader.jpg"));

		seperator();
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));

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
