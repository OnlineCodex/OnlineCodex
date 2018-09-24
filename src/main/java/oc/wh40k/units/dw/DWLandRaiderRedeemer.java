package oc.wh40k.units.dw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RefreshListener;

public class DWLandRaiderRedeemer extends Eintrag {

	public DWLandRaiderRedeemer() {
		name = "Land Raider Redeemer";
		grundkosten = 240;

		addToInformationVector("Land Raider Redeemer", 1);
		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderRedeemer.jpg"));

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
