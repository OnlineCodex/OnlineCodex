package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.Eintrag;

public class CHKytanRavager extends Eintrag {
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
    AnzahlPanel squad;

	public CHKytanRavager() {
		name = "Kytan Ravager";
		grundkosten = getPts("Kytan Ravager");

		ogE.addElement(new OptionsGruppeEintrag("Greater cleaver of Khorne", getPts("Greater cleaver of Khorne")));
		ogE.addElement(new OptionsGruppeEintrag("Warpsword", getPts("Warpsword")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Kytan gatling cannon", getPts("Kytan gatling cannon")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		o2.alwaysSelected();
	}
}
