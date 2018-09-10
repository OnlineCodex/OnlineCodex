package oc.wh40k.units.am;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AMValkyrieST extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

	public AMValkyrieST() {
		grundkosten = 70;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/ABVulture.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Rocket pots", "2 Multiple rocket pots", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        o1.alwaysSelected();
	}

}
