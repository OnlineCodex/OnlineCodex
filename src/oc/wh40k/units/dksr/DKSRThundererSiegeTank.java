package oc.wh40k.units.dksr;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class DKSRThundererSiegeTank extends RuestkammerVater {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade dozer;
	OptionsEinzelUpgrade mine;

	public DKSRThundererSiegeTank() {
		grundkosten = 140;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRuss.jpg"));
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", "Pintle-mounted Heavy stubber", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", "Pintle-mounted Storm bolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured track guards", 10));

		seperator();
		
		add(dozer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 5));
		add(mine =new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Mine plough", 15));
		
		sizeSetzen();
	}

  @Override
	public void refreshen() {
		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());

		dozer.setAktiv(!mine.isSelected());
		mine.setAktiv(!dozer.isSelected());
	}

}
