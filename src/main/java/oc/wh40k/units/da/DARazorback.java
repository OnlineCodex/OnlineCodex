package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DARazorback extends Eintrag {
	OptionsUpgradeGruppe o1, o2;

	public DARazorback() {
		name = "Razorback";
		grundkosten = 55;

		add(ico = new oc.Picture("oc/wh40k/images/SWEhrwuerdigerCybot.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bulldozerschaufel", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("HK Rakete", 10));
		ogE.addElement(new OptionsGruppeEintrag("Zusatzpanzerung", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setMaxAnzahl(o1.getNumberOfOptions());

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Multimelter [IA2]", "Synchronisierter Multimelter [Imperial Armour 2]", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone & Plasma", "Laserkanone und synchronisierter Plasmawerfer", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		o2.setSelected(0, true);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(!o2.isSelected()) o2.setSelected(0, true);
	}
}
