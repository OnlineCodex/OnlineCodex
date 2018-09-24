package oc.wh40k.units.kd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class KDForgefiend extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter ausruestung;

	public KDForgefiend() {
		name = "Forgefiend";
		grundkosten = 180;

		add(ico = new oc.Picture("oc/wh40k/images/Klauenmonstrum.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hadeskanonen", "2 Hades-Autokanonen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Ektoplasmakanonen", "2 Ektoplasma-Kanonen", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ektoplasma-Kanone", "zusätzliche Ektoplasma-Kanone", 25));
		
		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
	}

}
