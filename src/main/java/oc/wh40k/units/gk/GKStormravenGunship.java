package oc.wh40k.units.gk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKStormravenGunship extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public GKStormravenGunship() {
		name = "Stormraven Gunship";
		grundkosten = 200;

		add(ico = new oc.Picture("oc/wh40k/images/GKStormravenLandungsschiff.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Multimelter", "Synchronisierter Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Typhoon-Raketenwerfer", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Plasmakanone", "Synchronisierte Plasmakanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hurricane-Boltersysteme", "Seitenkuppeln mit Hurricane-Boltersystemen", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fliegerass", 50));
	
		complete();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
	}

}
