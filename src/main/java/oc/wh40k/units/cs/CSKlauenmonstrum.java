package oc.wh40k.units.cs;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CSKlauenmonstrum extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter ausruestung;

	public CSKlauenmonstrum() {
		name = "Klauenmonstrum";
		grundkosten = 125;

		add(ico = new oc.Picture("oc/wh40k/images/Klauenmonstrum.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Magmaschneider", "2 Magmaschneider", 0));
		ogE.addElement(new OptionsGruppeEintrag("Peitschententakel", "2 Paar Peitschententakel", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
	}

}
