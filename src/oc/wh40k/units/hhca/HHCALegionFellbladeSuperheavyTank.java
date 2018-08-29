package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class HHCALegionFellbladeSuperheavyTank extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3, o4;

	public HHCALegionFellbladeSuperheavyTank() {
		name = "Legion Fellblade Super-heavy Tank";
		grundkosten = 525;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Quad lascannon sponsons", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laser destroyer sponsons", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy flamer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 25));
		ogE.addElement(new OptionsGruppeEintrag("Command tank", 25));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Legion Crew", 15));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
				
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
		
	}

}
