package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IAImmolator extends Eintrag {
	OptionsUpgradeGruppe o1;

	public IAImmolator() {
		name = "Immolator";
		grundkosten = 60;

		add(ico = new oc.Picture("oc/wh40k/images/SWEhrwuerdigerCybot.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Multimelter", "Synchronisierter Multimelter", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		o1.setSelected(0, true);
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozer-Schaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stimmverstärker", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
