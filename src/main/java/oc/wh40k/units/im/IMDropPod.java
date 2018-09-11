package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMDropPod extends Eintrag {

	OptionsUpgradeGruppe o1;

	public IMDropPod() {
		name = "Drop Pod";
		grundkosten = getPts("Drop Pod");
		power = 5;

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Deathwind launcher", getPts("Deathwind launcher")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}
}
