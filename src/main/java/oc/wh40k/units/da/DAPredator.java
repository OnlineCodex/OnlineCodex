package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DAPredator extends Eintrag {

	OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

	public DAPredator() {
		name = "Predator";
		grundkosten = 75;

		add(ico = new oc.Picture("oc/wh40k/images/DAPredator.gif"));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", "Seitenkuppeln mit Schweren Boltern", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Laserkanonen", "Seitenkuppeln mit Laserkanonen", 40));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

		complete();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) {
			o1.setSelected("Maschinenkanone", true);
		}
	}

}
