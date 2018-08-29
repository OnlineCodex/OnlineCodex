package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class HHCALegionVindicator extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3;

	public HHCALegionVindicator() {
		name = "Legion Vindicator";
		grundkosten = 120;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Demolisher cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laser destroyer array", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
		ogE.addElement(new OptionsGruppeEintrag("Auxiliary drive", 10));
		ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
		ogE.addElement(new OptionsGruppeEintrag("Machine spirit", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
				
		if (!o1.isSelected()) o1.setSelected(0, true);
	}

}
