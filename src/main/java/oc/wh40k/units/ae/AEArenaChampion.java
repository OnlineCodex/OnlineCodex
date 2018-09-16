package oc.wh40k.units.ae;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AEArenaChampion extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

	public AEArenaChampion() {
	}

	@Override
	public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Drukhari)")));
        ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
