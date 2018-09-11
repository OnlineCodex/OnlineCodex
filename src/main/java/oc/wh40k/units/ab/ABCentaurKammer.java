package oc.wh40k.units.ab;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class ABCentaurKammer extends RuestkammerVater {

	public ABCentaurKammer() {
		grundkosten = 40;
	}

    @Override
	public void initButtons(boolean... defaults) {

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 20));

		sizeSetzen();
	}

    @Override
	public void refreshen() {

	}

}
