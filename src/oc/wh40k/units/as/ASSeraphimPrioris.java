package oc.wh40k.units.as;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ASSeraphimPrioris extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public ASSeraphimPrioris() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasma-Pistole", 15));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
