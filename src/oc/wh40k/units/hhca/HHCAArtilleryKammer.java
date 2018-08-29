package oc.wh40k.units.hhca;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class HHCAArtilleryKammer extends RuestkammerVater {

	OptionsUpgradeGruppe typ;
	OptionsUpgradeGruppe rhinoWeapons;
	OptionsPanelSwitcher switcher;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	
	public HHCAArtilleryKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Legion Basilisk", 140));
		ogE.addElement(new OptionsGruppeEintrag("Legion Medusa", 155));
		ogE.addElement(new OptionsGruppeEintrag("Legion Whirlwind", 75));
		add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		OptionsVater[] basilisk = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxiliary drive", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10),	
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Twin-linked bolter", 5),
		};
		
		OptionsVater[] medusa = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxiliary drive", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10),	
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Twin-linked bolter", 5),
		};
		
		OptionsVater[] whirlwind = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxiliary drive", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10),	
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Twin-linked bolter", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hyperios missiles", "Hyperios air-defence missiles", 0),
		};
		
		add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, basilisk, medusa, whirlwind));
			
		ogE.addElement(new OptionsGruppeEintrag("Phosphex shells", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!typ.isSelected()) {
			typ.setSelected(0, true);
		}
		
		if (typ.isSelected("Legion Basilisk")) {
			switcher.forceSwitchPanel(0);
		} else if (typ.isSelected("Legion Medusa")) {
			switcher.forceSwitchPanel(1);
		} else {
			switcher.forceSwitchPanel(2);
		}
		
		int phosphex = BuildaHQ.aktBuildaVater.getCountFromInformationVector("HHCASiege");
		o1.setAktiv (typ.isSelected(1) && phosphex >0);
		o1.getPanel().setLocation(
			(int) switcher.getPanel().getLocation().getX(),
			(int) switcher.getPanel().getLocation().getY() + switcher.getPanel().getSize().height + 8
		);
				
	}
	
}