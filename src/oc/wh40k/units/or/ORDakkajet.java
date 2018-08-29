package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORDakkajet extends Eintrag {

	OptionsUpgradeGruppe ss;
	
	public ORDakkajet() {
		name = "Dakkajet";
		grundkosten = getPts("Dakkajet");
		power = 7;

		add(ico = new oc.Picture("oc/wh40k/images/Dakkajet.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("4 supa shootas", getPts("supa shoota") * 4));
		ogE.addElement(new OptionsGruppeEintrag("6 supa shootas", getPts("supa shoota") * 6));
		add(ss = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	public void refreshen() {
		ss.alwaysSelected();
	}
}
