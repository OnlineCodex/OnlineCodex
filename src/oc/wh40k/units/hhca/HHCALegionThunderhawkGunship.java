package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class HHCALegionThunderhawkGunship extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3, o4;

	public HHCALegionThunderhawkGunship() {
		name = "Legion Thunderhawk Gunship";
		grundkosten = 900;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Thunderhawk cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Turbo-laser destructor", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bomb clusters", 0));
		ogE.addElement(new OptionsGruppeEintrag("6 Hellstrike missiles", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Chaff launcher", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured cockpit", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flare shield", 50));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
		complete();
	}

	@Override
	public void refreshen() {
				
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
	}

}
