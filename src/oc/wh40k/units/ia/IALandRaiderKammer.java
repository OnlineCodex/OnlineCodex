package oc.wh40k.units.ia;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IALandRaiderKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean[] defaults;

	public IALandRaiderKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		this.defaults = defaults;

		add(ico = new oc.Picture("oc/wh40k/images/SWLandRaider.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Land Raider", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Crusader", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Redeemer", 240));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}

}
