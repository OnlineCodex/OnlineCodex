package oc.wh40k.units.sm;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SMOrdenschampion extends RuestkammerVater {
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public SMOrdenschampion() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) {
			o1.setSelected(0, true);
		}
		
		if(!o2.isSelected()) {
			o2.setSelected(0, true);
		}
	}

}
