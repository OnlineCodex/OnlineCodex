package oc.wh40k.units.fo;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class FOGebaeude extends RuestkammerVater {
	
	OptionsUpgradeGruppe o1;

	public FOGebaeude() {}
	public void initButtons(boolean... defaults) {
		name = "Gebäude";
		grundkosten = 0;
		

		ogE.addElement(new OptionsGruppeEintrag("Deflektorschild", 25));
		ogE.addElement(new OptionsGruppeEintrag("Fluchtluke", 25));
		ogE.addElement(new OptionsGruppeEintrag("Magos-Maschinengeist", 30));
		ogE.addElement(new OptionsGruppeEintrag("Munitionsdepot", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sprengfallen", 20));
		ogE.addElement(new OptionsGruppeEintrag("Suchscheinwerfer", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE,defaults[0]?2:1));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}
}