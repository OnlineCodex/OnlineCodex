package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMContemptorMortisPatternDreadnought extends Eintrag {

	OptionsUpgradeGruppe o1;

	public SMContemptorMortisPatternDreadnought() {
		name = "Contemptor Mortis Pattern Dreadnought";
		grundkosten = 175;

		add(ico = new oc.Picture("oc/wh40k/images/SMCybot.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwere Bolter", "Zwei synchronisierter Schwere Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", "Zwei Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanonen", "Zwei synchronisierte Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kheres Assault Cannons", "Zwei Kheres Pattern Assault Cannons", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanonen", "Zwei synchronisierte Laserkanonen", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cyclone Missile Launcher", "Carapace-mounted Cyclone Missile Launcher", 35));

		complete();
	}

	@Override
	public void refreshen() {
                o1.alwaysSelected();
	}
	
}
