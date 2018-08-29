package oc.wh40k.units.ed;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class EDValkyrie extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public EDValkyrie() {
		grundkosten = 100;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGChimera.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Two Hellstrike missiles", 0));
		ogE.addElement(new OptionsGruppeEintrag("Two multiple rocket pods", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy Bolters", "Two sponsons with Heavy Bolters", 10));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
	}

}
