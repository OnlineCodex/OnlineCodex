package oc.wh40k.units.da;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DAPredatorKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public DAPredatorKammer() {
		name = "Predator";
		grundkosten = 75;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/SMPredator.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected("Maschinenkanone", true);

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Laserkanonen", 40));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(8);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) {
			o1.setSelected("Maschinenkanone", true);
		}
	}

	@Override
	public void deleteYourself() {

		super.deleteYourself();
	}

}
