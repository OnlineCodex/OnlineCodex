package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RH_IA13KhorneLordofSkulls extends Eintrag {

	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	public RH_IA13KhorneLordofSkulls() {
		name = "Khorne Lord of Skulls";
		grundkosten = 888;

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Gorestorm cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Ichor cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Daemongore cannon", 65));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hades gatling cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Skullhurler", 65));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o3.setSelected(0, true);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(!o2.isSelected()) o2.setSelected(0, true);
		if(!o3.isSelected()) o3.setSelected(0, true);
	}

}
