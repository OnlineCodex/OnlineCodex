package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMChaosContemptorDreadnought extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public CMChaosContemptorDreadnought() {
		name = "Chaos Contemptor Dreadnought";
		grundkosten = 195;

		add(ico = new oc.Picture("oc/wh40k/images/CMChaosContemptorDreadnought.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + sync. Bolter", "Cybot-Nahkampfwaffe + synchronisierter Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + SFlamer", "Cybot-Nahkampfwaffe + schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Plasma Bl", "Cybot-Nahkampfwaffe + Plasma Blaster", 20));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Soulburner", "Cybot-Nahkampfwaffe + Soulburner", 25));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Melta Gunr", "Cybot-Nahkampfwaffe + Melta Gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + sync. Bolter", "Kettenfaust + synchronisierter Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Butcher Cannon", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Butcher Cannon", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Conversion Beamer", 35));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + sync. Bolter", "Cybot-Nahkampfwaffe + synchronisierter Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + SFlamer", "Cybot-Nahkampfwaffe + schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Plasma Bl", "Cybot-Nahkampfwaffe + Plasma Blaster", 20));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Soulburner", "Cybot-Nahkampfwaffe + Soulburner", 25));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Melta Gunr", "Cybot-Nahkampfwaffe + Melta Gun", 15));	
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Dedicated to Khorne", 20));
		ogE.addElement(new OptionsGruppeEintrag("Dedicated to Nurgle", 20));
		ogE.addElement(new OptionsGruppeEintrag("Dedicated to Tzeentch", 20));
		ogE.addElement(new OptionsGruppeEintrag("Dedicated to Slaanesh", 15));
		
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Havoc Launcher", "Carapace-mounted Havoc Launcher", 15));

		complete();
	}

	@Override
	public void refreshen() {
                o1.alwaysSelected();
                o2.alwaysSelected();              
                
	}
	
}
